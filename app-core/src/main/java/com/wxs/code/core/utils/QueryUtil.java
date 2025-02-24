package com.wxs.code.core.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.hutool.core.bean.BeanUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成和解析各类条件的工具类
 * <p>
 * 支持：<p>
 * - 等值匹配：根据传入参数进行字段的精确匹配。 <p>
 * - 模糊匹配：若字符串参数两端包含'%'，则使用like匹配（左右模糊）；若只在一侧，则进行单侧模糊匹配。<p>
 * - 范围匹配：字段名称以"_from"或"_to"结尾时，分别生成大于等于或小于等于的查询条件。<p>
 * - 空值匹配：当参数值为"IS_NULL"时，匹配空值；当参数值为"IS_NOT_NULL"时，匹配非空。<p>
 * - 排序：若包含"columns"和"orderBy"参数，则按照指定列及顺序（asc或desc）排序。<p>
 * - 分页：通过"page"和"limit"参数构造分页对象。<p>
 * </p>
 */
public class QueryUtil {


    /**
     * 根据实体对象生成QueryWrapper查询条件
     * <p>
     * 支持等值、模糊、范围、空值/非空匹配以及排序。
     * 排序参数：实体中若包含"columns"和"orderBy"字段，则进行排序（orderBy值支持"asc"或"desc"）。
     * </p>
     *
     * @param entity 实体对象，包含查询条件参数
     * @param <T>    实体类型
     * @return QueryWrapper查询对象
     */
    public static <T> QueryWrapper<T> initWrappers(T entity) {
        return initWrappers(BeanUtil.beanToMap(entity));
    }


    /**
     * 重载方法示例：根据条件Map生成QueryWrapper查询条件
     * <p>
     * 该方法适用于外部已构造好条件Map的场景。
     * </p>
     *
     * @param paramMap 条件Map，键为字段名，值为查询值
     * @param <T>      实体类型
     * @return QueryWrapper查询对象
     */
    public static <T> QueryWrapper<T> initWrappers(Map<String, Object> paramMap) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            if ("columns".equals(key) || "orderBy".equals(key) || "page".equals(key) || "limit".equals(key)) {
                continue;
            }
            if (key.endsWith("_from")) {
                String realKey = key.substring(0, key.length() - 5);
                queryWrapper.ge(realKey, value);
            } else if (key.endsWith("_to")) {
                String realKey = key.substring(0, key.length() - 3);
                queryWrapper.le(realKey, value);
            } else if (value instanceof String strVal) {
                if ("IS_NULL".equalsIgnoreCase(strVal)) {
                    queryWrapper.isNull(key);
                } else if ("IS_NOT_NULL".equalsIgnoreCase(strVal)) {
                    queryWrapper.isNotNull(key);
                } else if (strVal.startsWith("%") && strVal.endsWith("%") && strVal.length() > 2) {
                    String content = strVal.substring(1, strVal.length() - 1);
                    queryWrapper.like(key, content);
                } else if (strVal.startsWith("%") && strVal.length() > 1) {
                    String content = strVal.substring(1);
                    queryWrapper.likeLeft(key, content);
                } else if (strVal.endsWith("%") && strVal.length() > 1) {
                    String content = strVal.substring(0, strVal.length() - 1);
                    queryWrapper.likeRight(key, content);
                } else {
                    queryWrapper.eq(key, value);
                }
            } else {
                queryWrapper.eq(key, value);
            }
        }
        // 排序处理：根据columns和orderBy参数进行排序
        if (paramMap.containsKey("columns") && paramMap.containsKey("orderBy")) {
            String columns = paramMap.get("columns").toString();
            String orderBy = paramMap.get("orderBy").toString().toLowerCase();
            String[] cols = columns.split(",");
            String[] orders = orderBy.split(",");

            // 如果排序数目与字段数目一致，则分别使用不同的排序规则
            if (orders.length == cols.length) {
                for (int i = 0; i < cols.length; i++) {
                    String col = cols[i].trim();
                    String order = orders[i].trim();
                    if (SortUtil.ASC.equals(order)) {
                        queryWrapper.orderByAsc(col);
                    } else if (SortUtil.DESC.equals(order)) {
                        queryWrapper.orderByDesc(col);
                    }
                }
            } else {
                // 否则，使用统一的排序方式
                for (String col : cols) {
                    col = col.trim();
                    if (SortUtil.ASC.equals(orderBy)) {
                        queryWrapper.orderByAsc(col);
                    } else if (SortUtil.DESC.equals(orderBy)) {
                        queryWrapper.orderByDesc(col);
                    }
                }
            }
        }
        return queryWrapper;
    }


    /**
     * 根据HttpServletRequest生成QueryWrapper查询条件
     * <p>
     * 从请求中获取参数并构造查询条件，支持等值、模糊、范围、空值/非空匹配以及排序。
     * </p>
     *
     * @param request HttpServletRequest对象
     * @return QueryWrapper查询对象
     */
    public static Map<String, Object> parseHttpRequests(HttpServletRequest request) {
        Map<String, Object> paramMap = new HashMap<>();
        // 从请求中提取参数（只取第一个值）
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (values != null && values.length > 0) {
                paramMap.put(key, values[0]);
            }
        }
        return paramMap;
    }

    /**
     * 根据HttpServletRequest生成QueryWrapper查询条件
     * <p>
     * 从请求中获取参数并构造查询条件，支持等值、模糊、范围、空值/非空匹配以及排序。
     * </p>
     *
     * @param request HttpServletRequest对象
     * @param <T>     实体类型
     * @return QueryWrapper查询对象
     */
    public static <T> QueryWrapper<T> initWrappers(HttpServletRequest request) {
        Map<String, Object> paramMap = parseHttpRequests(request);
        return initWrappers(paramMap);
    }


    public static <T> List<T> sort(List<T> data, Map<String, Object> paramMap) {
        String[] columns = null, orderBy;
        Object order = SortUtil.ASC;  // orderBy默认asc
        Object c = paramMap.get("columns");
        if (c != null)
            columns = c.toString().split(",");
        else
            columns = new String[]{"id", "createTime"};
        Object o = paramMap.get("orderBy");
        if (o != null) {
            orderBy = o.toString().split(",");
            order = orderBy.length == 0 ? SortUtil.ASC : orderBy.length == 1 ? orderBy[0] : orderBy; // 不传orderBy默认asc
        }
        if (columns != null || order != null)
            SortUtil.sort(data, columns, order);
        return data;
    }


    /**
     * 判断某个对象是否满足条件 Map 中定义的查询条件。
     * <p>
     * 模拟 QueryWrapper 中的规则：
     * - 如果字段名以 _from 结尾，则 item 中对应字段的值应大于等于条件值
     * - 如果字段名以 _to 结尾，则 item 中对应字段的值应小于等于条件值
     * - 对于字符串类型的条件：
     * - 如果条件为 "IS_NULL" 则对应字段值应为 null；
     * - 如果条件为 "IS_NOT_NULL" 则对应字段值应不为 null；
     * - 如果条件两端均为 '%' 且长度大于2，则进行包含匹配；
     * - 如果只以 '%' 开头，则进行右侧匹配（即字符串以指定内容结尾）；
     * - 如果只以 '%' 结尾，则进行左侧匹配（即字符串以指定内容开头）；
     * - 其它情况均按 equals 进行匹配。
     * <p>
     * 排序或分页相关的参数（如 "columns"、"orderBy"、"page"、"limit"）将会被忽略。
     *
     * @param item       待匹配的对象
     * @param conditions 条件 Map
     * @return 如果所有条件均满足则返回 true，否则 false
     */
    public static boolean matches(Object item, Map<String, Object> conditions) {
        Map<String, Object> itemMap = BeanUtil.beanToMap(item, false, true);
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String key = entry.getKey();
            // 忽略排序、分页相关的参数
            if ("columns".equalsIgnoreCase(key) || "orderBy".equalsIgnoreCase(key) || "pageNo".equalsIgnoreCase(key) || "pageSize".equalsIgnoreCase(key) || "page".equalsIgnoreCase(key) || "limit".equalsIgnoreCase(key)) {
                continue;
            }
            Object condValue = entry.getValue();
            if (condValue == null) {
                continue;
            }
            // 针对 _from 和 _to 后缀的处理
            if (key.endsWith("_from")) {
                String realKey = key.substring(0, key.length() - 5);
                Object fieldValue = itemMap.get(realKey);
                if (fieldValue == null || CompareUtil.compare(fieldValue, condValue) < 0) {
                    return false;
                }
            } else if (key.endsWith("_to")) {
                String realKey = key.substring(0, key.length() - 3);
                Object fieldValue = itemMap.get(realKey);
                if (fieldValue == null || CompareUtil.compare(fieldValue, condValue) > 0) {
                    return false;
                }
            } else if (condValue instanceof String condStr) {
                Object fieldValue = itemMap.get(key);
                if ("IS_NULL".equalsIgnoreCase(condStr)) {
                    if (fieldValue != null) {
                        return false;
                    }
                } else if ("IS_NOT_NULL".equalsIgnoreCase(condStr)) {
                    if (fieldValue == null) {
                        return false;
                    }
                } else if (condStr.startsWith("%") && condStr.endsWith("%") && condStr.length() > 2) {
                    String content = condStr.substring(1, condStr.length() - 1);
                    if (fieldValue == null || !fieldValue.toString().contains(content)) {
                        return false;
                    }
                } else if (condStr.startsWith("%") && condStr.length() > 1) {
                    // 只在左侧有 '%'，则判断右侧匹配（即以指定内容结尾）
                    String content = condStr.substring(1);
                    if (fieldValue == null || !fieldValue.toString().endsWith(content)) {
                        return false;
                    }
                } else if (condStr.endsWith("%") && condStr.length() > 1) {
                    // 只在右侧有 '%'，则判断左侧匹配（即以指定内容开头）
                    String content = condStr.substring(0, condStr.length() - 1);
                    if (fieldValue == null || !fieldValue.toString().startsWith(content)) {
                        return false;
                    }
                } else {
                    // 精确匹配
                    if (fieldValue == null || !fieldValue.equals(condValue)) {
                        return false;
                    }
                }
            } else if (condValue instanceof Number condNum) {
                Object fieldValue = itemMap.get(key);
                return 0 == (CompareUtil.compare(fieldValue, condNum));
            } else {
                // 非字符串类型的精确匹配
                Object fieldValue = itemMap.get(key);
                if (fieldValue == null || !fieldValue.equals(condValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
