/*
 *  @description: AppStarterApplication.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 下午5:59
 *  @date: 2024-6-25 18:2
 *
 */

package com.wxs.code;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
@Log4j2
public class AppStarterApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AppStarterApplication.class, args);

        Environment env = ctx.getEnvironment();
        log.info("""

                        ----------------------------------------------------------
                        \tApplication '{}' is running! Access URLs:
                        \tLocal: \t\thttp://localhost:{}
                        \tExternal: \thttp://{}:{}
                        \tDoc: \thttp://{}:{}/doc.html
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));

        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }

    }

}
