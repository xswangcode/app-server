/*
 *  @description: AuthWebMvcConfigurer.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/7 上午11:53
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.config;

import com.wxs.code.core.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthWebMvcConfigurer implements WebMvcConfigurer {
    final AuthHandlerInterceptor authHandlerInterceptor;

    public AuthWebMvcConfigurer(AuthHandlerInterceptor authHandlerInterceptor) {
        this.authHandlerInterceptor = authHandlerInterceptor;
    }

    /**
     * 给除了 /login 的接口都配置拦截器,拦截转向到 authHandlerInterceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authHandlerInterceptor)
                .addPathPatterns("/**")
                // swagger
                .excludePathPatterns("/swagger-resources/", "/webjars/", "/v3/**", "/swagger-ui.html/**","doc.html","/error")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/menu/getMenuCommon")
                .excludePathPatterns("/**/login");
    }
}
