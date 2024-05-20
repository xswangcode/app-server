package com.wxs.code.core.annotation;

import org.springframework.core.annotation.AliasFor;

public @interface HasRole {

    @AliasFor("names")
    String[] value();

    @AliasFor("value")
    String[] names();
}
