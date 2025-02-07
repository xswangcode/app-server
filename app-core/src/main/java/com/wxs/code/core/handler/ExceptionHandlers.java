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


import cn.dev33.satoken.exception.NotPermissionException;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.exception.AuthExecption;
import com.wxs.code.core.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {


    // 统一异常处理
    @ExceptionHandler(AuthExecption.class)
    public RspMsg exceptionHandler_auth(Exception e) {
        return RspMsg.noauth(e.getMessage());
    }

    // 统一异常处理
    @ExceptionHandler(SystemException.class)
    public RspMsg exceptionHandler_auto(SystemException e) {
        return RspMsg.error(e.getMessage());
    }
    // 统一异常处理
    @ExceptionHandler(RuntimeException.class)
    public RspMsg exceptionHandler_ALL(RuntimeException e) {
        return RspMsg.error(e.getMessage());
    }

    // 全局权限异常拦截
    @ExceptionHandler(NotPermissionException.class)
    public RspMsg handlerException(NotPermissionException e) {
        return RspMsg.error("没有权限访问");
    }
}
