package com.wxs.code.system.aspect;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.constant.RedisConstants;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.constant.SystemConstants;
import com.wxs.code.core.utils.QueryUtil;
import com.wxs.code.core.utils.RedisUtil;
import com.wxs.code.system.sysdict.service.IDictService;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.dromara.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class AutoCacheAOP {

    @Autowired
    IDictService dictService;


    /**
     * execution(* com.wxs.code.*.controller.*.*(..))
     * 第一个*表示返回值类型，*表示所有的返回值类型，
     * 第二个*表示com.wxs.code包下的所有类，
     * 如何設置指定的方法
     * 最后括号里的两个..表示方法的参数，两个..表示任何参数
     */
    @Pointcut(value = "execution(* com.wxs.code.*.controller.*.*(..))")
    public void pointCut() {
    }

    // 环绕点
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取controller 全称
        String className = joinPoint.getTarget().getClass().getName();
        List<SysDictItem> cacheTables = getCacheTables();
        Optional<SysDictItem> allow_cache = cacheTables.stream().filter(x -> className.equalsIgnoreCase(x.getValue2())).findFirst();
        if (allow_cache.isPresent()) {
            // 获取方法名
            String methodName = joinPoint.getSignature().getName();
            // 获取方法参数
            Object[] args = joinPoint.getArgs();
            return processCache(methodName, allow_cache.get().getCode(), args, joinPoint);
        }
        return joinPoint.proceed();
    }


    private List<SysDictItem> getCacheTables() {
        List<SysDictItem> tbs = RedisUtil.get(RedisConstants.CACHE_TABLES_KEY, List.class);
        if (tbs != null && !tbs.isEmpty()) {
            return tbs;
        }
        List<SysDictItem> sysDictItems = dictService.listDictItemByCode(SystemConstants.SYS_DICT.CACHE_TABLES);
        RedisUtil.set(RedisConstants.CACHE_TABLES_KEY, sysDictItems);
        return sysDictItems;
    }

    /**
     * 获取方法的策略
     *
     * @param methodName
     * @param code
     * @param args
     * @param joinPoint
     */
    private Object processCache(String methodName, String code, Object[] args, ProceedingJoinPoint joinPoint) throws Throwable {
        switch (methodName) {
            case "add":
            case "edit":
                return handleAddEdit(joinPoint, code, args);
            case "queryPageList":
                return handleQueryPageListList(joinPoint, code, args);
            case "list":
                return handleListList(joinPoint, code, args);
            case "addBatch":
                return handleAddBatch(joinPoint, code, args);
            case "delete":
                return handleDelete(joinPoint, code, args);
            case "deleteBatch":
                return handleDeleteDeleteBatch(joinPoint, code, args);
            case "queryById":
                return handleQueryById(joinPoint, code, args);
            default:
                return joinPoint.proceed();
        }
    }

    /**
     * 新增/编辑AOP
     *
     * @param joinPoint
     * @param code
     * @param args
     * @return
     * @throws Throwable
     */
    private Object handleAddEdit(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {
        // 调用原方法
        Object result = joinPoint.proceed();
        String key = generateCacheKey(code, BeanUtil.beanToMap(args[0]).get("id").toString());
        RedisUtil.set(key, args[0]);
        return result;
    }

    /**
     * 批量编辑AOP
     */
    private Object handleAddBatch(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {
        // 调用原方法
        Object result = joinPoint.proceed();

        List<?> entity = (List<?>) args[0];
        for (Object o : entity) {
            String key = generateCacheKey(code, BeanUtil.beanToMap(o).get("id").toString());
            RedisUtil.set(key, o);
        }
        return result;
    }


    /**
     * 删除AOP
     */
    private Object handleDelete(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {
        // 调用原方法
        Object result = joinPoint.proceed();

        String id = String.valueOf(args[0]);
        String key = generateCacheKey(code, id);
        RedisUtil.del(key);
        return result;
    }


    /**
     * 批量删除AOP
     */
    private Object handleDeleteDeleteBatch(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {
        // 调用原方法
        Object result = joinPoint.proceed();

        List<?> entity = (List<?>) args[0];
        for (Object o : entity) {
            String key = generateCacheKey(code, BeanUtil.beanToMap(o).get("id").toString());
            RedisUtil.del(key);
        }
        return result;
    }


    /**
     * 条件查询AOP（仅等值匹配）
     */
    private Object handleListList(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {

        Object entity = args[0];
        Class<?> clazz = entity.getClass();
        List<?> byPattern = RedisUtil.getByPattern(code + ":*", clazz);
        Map<String, Object> paramMap = QueryUtil.parseHttpRequests((RequestFacade) args[1]);
        // 过滤：仅保留满足条件的对象
        List<?> data = byPattern.stream().filter(item -> QueryUtil.matches(item, paramMap)).collect(Collectors.toList());

        // 无数据走数据库
        if (data.isEmpty()) {
            Object _rsp = joinPoint.proceed();
            // 重置缓存
            if (_rsp instanceof RspMsg) {
                RspMsg<?> rsp = (RspMsg<?>) _rsp;
                Object result = rsp.getResult();
                if (rsp.isSuccess() && result instanceof List && !((List<?>) result).isEmpty())
                    for (Object o : ((List<?>) result)) {
                        String key = generateCacheKey(code, BeanUtil.beanToMap(o).get("id").toString());
                        RedisUtil.set(key, o);
                    }
            }
            return _rsp;
        }
        QueryUtil.sort(data, paramMap);
        return RspMsg.OK(data);
    }

    /**
     * 分页查询AOP（仅等值匹配）
     */
    private Object handleQueryPageListList(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {
        Object entity = args[0];
        Class<?> clazz = entity.getClass();
        List<?> byPattern = RedisUtil.getByPattern(code + ":*", clazz);
        Map<String, Object> paramMap = QueryUtil.parseHttpRequests((RequestFacade) args[3]);
        // 过滤：仅保留满足条件的对象
        List<?> filteredList = byPattern.stream().filter(item -> QueryUtil.matches(item, paramMap)).collect(Collectors.toList());

        // 无数据走数据库
        if (filteredList.isEmpty()) {
            Object _rsp = joinPoint.proceed();
            // 重置缓存
            if (_rsp instanceof RspMsg<?> rsp) {
                Object result = rsp.getResult();
                if (rsp.isSuccess() && result instanceof IPage<?> && !((IPage<?>) result).getRecords().isEmpty()) {
                    List<?> data = ((IPage<?>) result).getRecords();
                    for (Object o : data) {
                        String key = generateCacheKey(code, BeanUtil.beanToMap(o).get("id").toString());
                        RedisUtil.set(key, o);
                    }
                }
                return _rsp;
            }
        }

        int pageNO = Integer.parseInt(args[1].toString());
        int pageSize = Integer.parseInt(args[2].toString());
        int from = (pageNO - 1) * pageSize;
        int to = pageNO * pageSize;
        from = Math.min(from, filteredList.size());
        to = Math.min(to, filteredList.size());

        QueryUtil.sort(filteredList, paramMap);
        List<?> data = filteredList.subList(from, to);
        IPage page = new Page<>(pageNO, pageSize);
        page.setTotal(filteredList.size());
        page.setRecords(data);
        return RspMsg.OK(page);

    }


    /**
     * 通过Id查询数据AOP
     */
    private RspMsg handleQueryById(ProceedingJoinPoint joinPoint, String code, Object[] args) throws Throwable {

        String id = String.valueOf(args[0]);
        String key = generateCacheKey(code, id);
        Object cache = RedisUtil.get(key);
        if (cache != null) return RspMsg.OK(cache);
        // 调用原方法
        RspMsg rspmsg = (RspMsg) joinPoint.proceed();
        if (rspmsg.isSuccess()) {
            Object entity = rspmsg.getResult();
            RedisUtil.set(key, entity);
        }
        return rspmsg;
    }

    /**
     * 生成缓存键
     *
     * @param tableName
     * @param id
     * @return
     */
    private String generateCacheKey(String tableName, Serializable id) {
        return tableName + ":" + id;
    }

    /**
     * 刪除方法的策略
     * 策略的英語單詞：
     * 1.strategy:策略
     *
     * @param code
     * @param args
     */
    private void handleDelete(String code, Object[] args) {
        if (args.length == 0) return;
        RedisUtil.del(code + ":" + args[0]);
    }


}
