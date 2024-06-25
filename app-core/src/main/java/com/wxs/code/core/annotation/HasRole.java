/*
 *  @description: HasRole.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/20 下午6:00
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.annotation;

import org.springframework.core.annotation.AliasFor;

public @interface HasRole {

    @AliasFor("names")
    String[] value();

    @AliasFor("value")
    String[] names();
}
