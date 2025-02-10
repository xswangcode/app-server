/*
 *  @description: CacheConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025/2/10 下午3:14
 *  @date: 2025-2-10 15:14
 *
 */

package com.wxs.code.core.config;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private RedissonClient redissonClient;

    @Bean
    public CacheManager cacheManager() {
        return new RedissonSpringCacheManager(redissonClient);
    }
}