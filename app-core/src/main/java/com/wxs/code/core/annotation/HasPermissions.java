/*
 *  @description: HasPermissions.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午10:51
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.annotation;

import org.springframework.core.annotation.AliasFor;


/**
 * 具有权限注解
 */
public @interface HasPermissions {

    @AliasFor("names")
    String value() default "";

    @AliasFor("value")
    String names() default "";

    String description() default "";
}
