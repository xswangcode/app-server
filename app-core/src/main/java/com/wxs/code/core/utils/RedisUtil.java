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

    private static final RedissonClient redisson;

    static {
        redisson = SpringUtils.get(RedissonClient.class);
    }

    public static String get(String key) {
        RBucket<String> bucket = redisson.getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return "";
        }
        return redisson.getBucket(key).get().toString();
    }

    public static Object getOrDefault(String key, Object object) {
        RBucket<String> bucket = redisson.getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return object;
        }
        return redisson.getBucket(key).get().toString();
    }

    public static <T> T get(String key, Class<T> clazz) {
        RBucket<String> bucket = redisson.getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return null;
        }
        return JSONUtil.toBean(str, clazz);
    }

    public static void set(String key, Object val) {
        String jsonStr = JSONUtil.toJsonStr(val);
        redisson.getBucket(key).set(jsonStr);
    }

    public static void set(String key, Object val, Duration duration) {
        String jsonStr = JSONUtil.toJsonStr(val);
        redisson.getBucket(key).set(jsonStr, duration);
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
        redisson.getBucket(key).set(jsonStr, Duration.ofSeconds(seconds));
    }

    /**
     * @param key
     */
    public static boolean exists(String key) {
        return redisson.getBucket(key).isExists();
    }
}
