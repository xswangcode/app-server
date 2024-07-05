/*
 *  @description: AuthWebMvcConfigurer.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/7/5 下午5:59
 *  @date: 2024-7-5 17:59
 *
 */

package com.wxs.code.core.config;

import com.wxs.code.core.interceptor.AuthHandlerInterceptor;
import com.wxs.code.core.utils.ConfigUtil;
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
        if (!ConfigUtil.appConfig().getDebug().getEnable())
            registry.addInterceptor(authHandlerInterceptor)
                .addPathPatterns("/**")
                // swagger
                .excludePathPatterns("/swagger-resources/", "/webjars/", "/v3/**", "/swagger-ui.html/**","doc.html","/error")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/menu/getMenuCommon")
                .excludePathPatterns("/**/login");
    }
}
