/*
 *  @description: HasRoleAOP.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午10:11
 *  @date: 2024-6-25 10:51
 *
 */

package com.wxs.code.system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * &#064;Author:  xswang
 * &#064;Describe:  角色权限
 */
@Component
@Aspect
@Slf4j
public class HasRoleAOP {


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
