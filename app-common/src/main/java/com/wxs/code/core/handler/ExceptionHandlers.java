package com.wxs.code.core.handler;


import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.exception.AuthExecption;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlers {

    // 统一异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RspMsg exceptionHandler_ALL(Exception e){
        return RspMsg.error(e.getMessage());
    }

    // 统一异常处理
    @ExceptionHandler(AuthExecption.class)
    @ResponseBody
    public RspMsg exceptionHandler_auth(Exception e){
        return RspMsg.noauth(e.getMessage());
    }
}
