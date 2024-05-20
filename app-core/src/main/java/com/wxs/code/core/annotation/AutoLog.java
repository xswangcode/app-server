package com.wxs.code.core.annotation;

import com.wxs.code.core.constant.LogConstant;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    /**
     * 是否持久化
     *
     * @return
     */
    boolean value() default false;

    /**
     * 操作类型
     *
     * @return
     */
    LogConstant.LogType type() default LogConstant.LogType.OPERATION;

    /**
     * 操作等级
     *
     * @return
     */
    LogConstant.LogLeval leval() default LogConstant.LogLeval.DEFAULT;

    /**
     * 操作描述
     */
    String title() default "";

}
