/*
 *  @description: ExceptionHandlers.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.handler;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.wxs.code.core.annotation.AutoLog;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.constant.LogConstant;
import com.wxs.code.core.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(SystemException.class)
    @AutoLog(value = true, type = LogConstant.LogType.EXCEPTION, leval = LogConstant.LogLeval.ERROR, title = "系统运行异常")
    public RspMsg exceptionHandler_auto(SystemException e) {
        return RspMsg.error(e.getMessage() == null ? e.getCause().getMessage() : e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @AutoLog(value = true, type = LogConstant.LogType.EXCEPTION, leval = LogConstant.LogLeval.ERROR, title = "未定义系统运行异常")
    public RspMsg exceptionHandler_ALL(RuntimeException e) {
        log.error("未定义系统运行异常===> \n{0}", e);
        return RspMsg.error(e.getMessage() == null ? e.getCause().getMessage() : e.getMessage());
    }

    // 全局权限异常拦截
    @ExceptionHandler(NotPermissionException.class)
    @AutoLog(value = true, type = LogConstant.LogType.EXCEPTION, leval = LogConstant.LogLeval.ERROR, title = "权限异常")
    public RspMsg handlerNotPermissionException(NotPermissionException e) {
        return RspMsg.error("没有权限访问");
    }

    // 全局权限异常拦截
    @ExceptionHandler(NotLoginException.class)
    public RspMsg handlerNotLoginException(NotLoginException e) {
        return RspMsg.error(e.getMessage());
    }
}
