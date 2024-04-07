package com.wxs.code.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableKnife4j
public class OpenAPIConfig {
    private License license() {
        return new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");
    }

    private Info info() {
        return new Info()
                .title("App server API")
                .description("后端接口文档")
                .version("v1.0.0")
                .summary("这是一个接口文档的示例。")
                .license(license());

    }


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .schemaRequirement("X-Access-Token", new SecurityScheme().type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).name("X-Access-Token"))
                .info(info());
    }
}
