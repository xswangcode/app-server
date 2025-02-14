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

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.redisson.spring.starter.RedissonProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableCaching
public class CacheConfig {

    private final RedissonProperties redissonProperties;

    public CacheConfig(RedissonProperties redissonProperties) {
        this.redissonProperties = redissonProperties;
    }

    @Bean
    public RedissonClient redissonClient() throws IOException {
        // 获取 spring.redis.redisson写的配置
        Config config = Config.fromYAML(redissonProperties.getConfig());
        return Redisson.create(config);
    }

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        return new RedissonSpringCacheManager(redissonClient);
    }
}