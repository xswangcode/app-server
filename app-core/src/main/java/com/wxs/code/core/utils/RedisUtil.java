/*
 *  @description: RedisUtil.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/23 下午12:58
 *  @date: 2024-12-23 12:58
 *
 */

package com.wxs.code.core.utils;

import org.dromara.hutool.json.JSONUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.time.Duration;

/**
 * redis工具类
 * 可扩展
 */
public class RedisUtil {

    /**
     * 单例获取实例
     */
    private RedisUtil() {
        // 私有构造函数，防止外部实例化
    }

    private static RedissonClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 工具方法
     */

    public static String get(String key) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return "";
        }
        return getInstance().getBucket(key).get().toString();
    }

    public static <T extends Object> T getOrDefault(String key, T object) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return object;
        }
        return (T) getInstance().getBucket(key).get();
    }

    public static <T> T get(String key, Class<T> clazz) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return null;
        }
        return JSONUtil.toBean(str, clazz);
    }

    public static void set(String key, Object val) {
        String jsonStr = JSONUtil.toJsonStr(val);
        getInstance().getBucket(key).set(jsonStr);
    }

    public static void set(String key, Object val, Duration duration) {
        String jsonStr = JSONUtil.toJsonStr(val);
        getInstance().getBucket(key).set(jsonStr, duration);
    }

    /**
     * 设置键值和过期时间（秒）
     *
     * @param key
     * @param val
     * @param seconds
     */
    public static void set(String key, Object val, Long seconds) {
        String jsonStr = JSONUtil.toJsonStr(val);
        getInstance().getBucket(key).set(jsonStr, Duration.ofSeconds(seconds));
    }

    /**
     * @param key
     */
    public static boolean exists(String key) {
        return getInstance().getBucket(key).isExists();
    }

    private static class SingletonHolder {
        private static final RedissonClient INSTANCE = SpringUtils.get(RedissonClient.class);
    }
}
