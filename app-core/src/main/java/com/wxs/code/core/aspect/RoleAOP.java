package com.wxs.code.core.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class RoleAOP {

    LocalDateTime start;
    LocalDateTime end;

    /**
     * controller 目录下的所有控制器
     */
    @Pointcut(value = "execution(* com.wxs.code..controller.*.*(..))")
    public void pointCut() {
    }


    /**
     * 前置方法
     */
    @Before(value = "pointCut()")
    public void before() {

    }


}
