package com.wxs.code.core.utils;

import org.dromara.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 排序工具类
 * <p>
 * 提供静态方法 sortData 对数据列表进行排序：
 * <ul>
 *   <li>data：待排序的数据列表</li>
 *   <li>columns：排序依据的字段数组，按照数组中字段的先后顺序依次比较</li>
 *   <li>orderBy：
 *       <ul>
 *         <li>若为单值 "asc" 或 "desc"，表示所有字段均使用该排序方式</li>
 *         <li>若为与 columns 长度一致的字符串数组，则分别按照对应字段的排序方式进行排序</li>
 *       </ul>
 *   </li>
 * </ul>
 * </p>
 */
public class SortUtil {

    public static final String ASC = "asc";
    public static final String DESC = "desc";


    /**
     * 对数据列表进行排序
     *
     * @param data    待排序的数据列表
     * @param columns 排序依据的字段数组
     * @param orderBy 排序方式，既可以为单值“asc”，也可以为与 columns 长度一致的数组
     * @param <T>     数据类型
     * @throws IllegalArgumentException 如果 orderBy 参数既不是 String 也不是 String[]，
     *                                  或者当为 String[] 时，其长度与 columns 不一致
     */
    public static <T> void sort(List<T> data, String[] columns, Object orderBy) {
        if (data == null || data.isEmpty() || columns == null || columns.length == 0) {
            return;
        }
        // 构造每个字段的排序规则数组：true 表示升序，false 表示降序
        boolean[] ascArr = new boolean[columns.length];

        if (orderBy instanceof String) {
            // 单一排序规则，适用于所有字段
            boolean asc = ASC.equalsIgnoreCase((String) orderBy);
            for (int i = 0; i < columns.length; i++) {
                ascArr[i] = asc;
            }
        } else if (orderBy instanceof String[] orders) {
            if (orders.length != columns.length) {
                throw new IllegalArgumentException("orderBy 数组长度必须与 columns 长度一致");
            }
            for (int i = 0; i < orders.length; i++) {
                ascArr[i] = ASC.equalsIgnoreCase(orders[i]);
            }
        } else {
            throw new IllegalArgumentException("orderBy 参数必须为 String 或 String[] 类型");
        }

        // 利用 Java 8 lambda 表达式对列表进行排序
        data.sort((o1, o2) -> {
            for (int i = 0; i < columns.length; i++) {
                // 判断对象是否有字段属性
                if (!hasField(o2, columns[i].trim())) {
                    continue;
                }

                // 通过 BeanUtil 获取对象的属性值
                Object val1 = BeanUtil.getProperty(o1, columns[i].trim());
                Object val2 = BeanUtil.getProperty(o2, columns[i].trim());
                // 使用 CompareUtil.compare 方法进行比较，内部已处理 null 值
                int cmp = CompareUtil.compare(val1, val2);
                if (cmp != 0) {
                    // 根据该字段对应的排序规则返回结果
                    return ascArr[i] ? cmp : -cmp;
                }
            }
            return 0;
        });
    }


    /**
     * 查询obj中是否有filedName字段
     *
     * @param object
     * @param fieldName
     * @return
     */
    public static boolean hasField(Object object, String fieldName) {
        Class<?> objectClass = object.getClass();
        for (Field field : objectClass.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                return true;
            }
        }
        return false;
    }

}
