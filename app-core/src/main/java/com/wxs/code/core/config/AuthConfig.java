/*
 *  @description: AuthConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/4/3 下午2:01
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.config;


import jakarta.annotation.PostConstruct;
import org.dromara.hutool.json.jwt.signers.JWTSigner;
import org.dromara.hutool.json.jwt.signers.JWTSignerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {
    @Value("${app.token.secretKey}")
    public String sign;

    /**
     * 刷新token时间,多久刷新一次token
     */
    @Value("${app.token.refreshTime}")
    public Long refreshTime;

    /**
     * 超期时间，超过指定时长，无法无感刷新
     */
    @Value("${app.token.expiresTime}")
    public Long expiresTime;


    public JWTSigner JWT_SIGNER;

    @PostConstruct
    void init() {
        JWT_SIGNER = JWTSignerUtil.hs512(sign.getBytes());
    }
}
