/*
 *  @description: SpringUtils.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:12
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T get(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getByFullname(String fullName) {
        try {
            Class<?> clazz = Class.forName(fullName);
            return (T) applicationContext.getBean(clazz);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }


    public static Object get(String name) {
        return applicationContext.getBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
}
