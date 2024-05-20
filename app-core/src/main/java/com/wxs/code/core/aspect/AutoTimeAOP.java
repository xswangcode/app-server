package com.wxs.code.core.aspect;

import com.wxs.code.core.annotation.AutoLog;
import com.wxs.code.core.constant.LogConstant;
import com.wxs.code.core.entity.system.SysLog;
import com.wxs.code.core.entity.system.SysUser;
import com.wxs.code.core.service.system.ISysLogService;
import com.wxs.code.core.utils.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.dromara.hutool.core.array.ArrayUtil;
import org.dromara.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 计算方法执行的时间
 */
@Component
@Aspect
@Slf4j
public class AutoTimeAOP {

    final ISysLogService logSvc;
    long start;
    long end;

    public AutoTimeAOP(ISysLogService logSvc) {
        this.logSvc = logSvc;
    }

    /**
     * controller 目录下的所有控制器
     */
    @Pointcut(value = "@annotation(com.wxs.code.core.annotation.AutoLog)")
    public void pointCut() {
    }


    /**
     * 前置方法
     */
    @Before(value = "pointCut()")
    public void before() {
        start = System.currentTimeMillis();
    }


    //方法执行后的点
    @After(value = "pointCut()")
    public void after() {
        end = System.currentTimeMillis();
    }

    // 环绕点
    @Around("@annotation(autoLog)")
    public Object around(ProceedingJoinPoint joinPoint, AutoLog autoLog) throws Throwable {
        log.info("====================AOP 开始执行方法===========================");
        start = System.currentTimeMillis();
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        String Fun = joinPoint.getStaticPart().getSignature().toString();
        log.info("Fun {} ,请求参数为{}", Fun, args);
        Object result = null;
        LogConstant.LogLeval paramsLeval = autoLog.leval();
        try {
            result = joinPoint.proceed(args);
        } catch (Exception e) {
            paramsLeval = LogConstant.LogLeval.ERROR;
            result = e.getStackTrace();
        }
        end = System.currentTimeMillis();

        //
        String paramsArgs = ArrayUtil.isEmpty(args) ? null : JSONUtil.toJsonStr(args);
        String paramsResult = result == null ? null : JSONUtil.toJsonStr(result);

        //如果这里不返回result，则目标对象实际返回值会被置为null
        process(autoLog, paramsLeval, paramsArgs, paramsResult, end - start);
        log.info("====================AOP 结束执行方法===========================");
        return result;
    }

    /**
     * 核心处理逻辑
     */
    private void process(AutoLog autoLog, LogConstant.LogLeval paramsLeval, String params, String response, Long spendTime) {
        SysUser user = SystemUtil.getUser();
        String ip = SystemUtil.getIpAddr();
        SysLog log = SysLog.builder().logLevel(paramsLeval).type(autoLog.type()).params(params).response(response).spendTime(spendTime)
                .timespan(LocalDateTime.now()).createBy(user.getName()).createById(user.getId()).clientIp(ip).build();
        logSvc.save(log);
    }


}
