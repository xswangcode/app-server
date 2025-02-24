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

import org.dromara.hutool.core.bean.BeanUtil;
import org.dromara.hutool.json.JSONUtil;
import org.redisson.api.RBatch;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    public static String getJSON(String key) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return "";
        }
        return getInstance().getBucket(key).get().toString();
    }

    public static <T extends Object> T getJSONOrDefault(String key, T object) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return object;
        }
        return (T) getInstance().getBucket(key).get();
    }

    public static <T> T getJSON(String key, Class<T> clazz) {
        RBucket<String> bucket = getInstance().getBucket(key);
        String str = bucket.get();
        if (str == null) {
            return null;
        }
        return JSONUtil.toBean(str, clazz);
    }

    public static void setJSON(String key, Object val) {
        String jsonStr = JSONUtil.toJsonStr(val);
        getInstance().getBucket(key).set(jsonStr);
    }

    public static void setJSON(String key, Object val, Duration duration) {
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
    public static void setJSON(String key, Object val, Long seconds) {
        String jsonStr = JSONUtil.toJsonStr(val);
        getInstance().getBucket(key).set(jsonStr, Duration.ofSeconds(seconds));
    }


    public static Object get(String key) {
        RBucket<Object> bucket = getInstance().getBucket(key);
        Object obj = bucket.get();
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static <T extends Object> T getOrDefault(String key, T defval) {
        RBucket<Object> bucket = getInstance().getBucket(key);
        Object obj = bucket.get();
        if (obj == null) {
            return defval;
        }
        return (T) obj;
    }

    public static <T extends Object> T get(String key, Class<T> clazz) {
        RBucket bucket = getInstance().getBucket(key);
        Object obj = bucket.get();
        if (obj == null) {
            return null;
        }
        return BeanUtil.toBean(obj, clazz);
    }

    public static void set(String key, Object val) {
        getInstance().getBucket(key).set(val);
    }

    public static void set(String key, Object val, Duration duration) {
        getInstance().getBucket(key).set(val, duration);
    }

    /**
     * 设置键值和过期时间（秒）
     *
     * @param key
     * @param val
     * @param seconds
     */
    public static void set(String key, Object val, Long seconds) {
        getInstance().getBucket(key).set(val, Duration.ofSeconds(seconds));
    }

    /**
     * 通过键模板查询keys
     *
     * @param keyPattern
     */
    public static Iterable<String> getKeysByPattern(String keyPattern) {
        RedissonClient instance = getInstance();
        return instance.getKeys().getKeysByPattern(keyPattern);
    }


    /**
     * 通过键模板查询entity
     *
     * @param keyPattern
     */
    public static <T> List<T> getByPattern(String keyPattern, Class<T> clazz) {
        Iterable<String> keys = getInstance().getKeys().getKeysByPattern(keyPattern);
        List<T> result = new ArrayList<>();
        keys.forEach(key -> {
            Object it = getInstance().getBucket(key).get();
            if (it != null) {
                T t = BeanUtil.toBean(it, clazz);
                result.add(t);
            }
        });
        return result;
    }

    /**
     * 通过键模板删除keys
     *
     * @param keyPattern
     */
    public static long deleteByPattern(String keyPattern) {
        RedissonClient instance = getInstance();
        return instance.getKeys().deleteByPattern(keyPattern);
    }



    /**
     * @param key
     */
    public static boolean exists(String key) {
        return getInstance().getBucket(key).isExists();
    }

    /**
     * 获取批量设置工具
     *
     * @param
     */
    public static RBatch getBatch() {
        return getInstance().createBatch();
    }

    public static boolean del(String key) {
        return getInstance().getBucket(key).delete();
    }


    private static class SingletonHolder {
        private static final RedissonClient INSTANCE = SpringUtils.get(RedissonClient.class);
    }
}
