/*
 *  @description: JFinalEnjoyConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.configs;


import com.jfinal.template.Engine;
import com.wxs.code.core.ext.spring.JFinalViewResolver;
import com.wxs.code.generate.directive.TransformedIntoSmallHumpNomenclatureDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JFinalEnjoyConfig {

    @Bean(name = "jfinalViewResolver")
    public JFinalViewResolver jFinalViewResolver() {
        // 创建用于整合 spring boot 的 ViewResolver 扩展对象
        JFinalViewResolver jfr = new JFinalViewResolver();

        jfr.addDirective("toSmallHumpName", TransformedIntoSmallHumpNomenclatureDirective.class);
        // 对 spring boot 进行配置
        jfr.setSuffix(".template");
        jfr.setContentType("text/html;charset=UTF-8");
        jfr.setOrder(0);

        // 获取 engine 对象，对 enjoy 模板引擎进行配置，配置方式与前面章节完全一样
        Engine engine = JFinalViewResolver.engine;

        // 热加载配置能对后续配置产生影响，需要放在最前面
        engine.setDevMode(true);

        // 使用 ClassPathSourceFactory 从 class path 与 jar 包中加载模板文件
        engine.setToClassPathSourceFactory();

        // 在使用 ClassPathSourceFactory 时要使用 setBaseTemplatePath
        // 代替 jfr.setPrefix("/view/")
        engine.setBaseTemplatePath("/templates/enjoy/");

        // 添加模板函数
        // engine.addSharedFunction("/common/_layout.html");
        // engine.addSharedFunction("/common/_paginate.html");

        // 更多配置与前面章节完全一样
        // engine.addDirective(...)
        // engine.addSharedMethod(...);

        return jfr;
    }
}
