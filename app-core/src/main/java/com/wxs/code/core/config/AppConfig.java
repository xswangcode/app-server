/*
 *  @description: AppConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/7/5 下午5:59
 *  @date: 2024-7-5 17:59
 *
 */

package com.wxs.code.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppConfig {

    ServerProperties server = new ServerProperties();
    TokenProperties token = new TokenProperties();
    LoginProperties login = new LoginProperties();
    DebugProperties debug = new DebugProperties();


    @Getter
    @Setter
    public class ServerProperties {
        String host;
    }

    @Getter
    @Setter
    public class TokenProperties {
        String secretKey; // 签名
        Long refreshTime; // 无感刷新时间 /s
        Long expiresTime; // 超期时间 /s
    }

    @Getter
    @Setter
    public class LoginProperties {

        private Github github = new Github();

        @Getter
        @Setter
        public class Github {
            String client_id;
            String client_secret;
        }
    }

    @Getter
    @Setter
    public class DebugProperties {
        Boolean enable;
    }

}
