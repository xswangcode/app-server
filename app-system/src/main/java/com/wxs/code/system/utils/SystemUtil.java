/*
 *  @description: SystemUtil.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.system.utils;

import com.wxs.code.core.constant.CommonConstants;
import com.wxs.code.core.exception.AuthExecption;
import com.wxs.code.core.utils.SpringUtils;
import com.wxs.code.system.entity.SysUser;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.json.JSONUtil;
import org.dromara.hutool.json.jwt.JWT;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;


@Component
public class SystemUtil {

    static RedissonClient redissonClient;

    @NotNull
    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()));
        return requestAttributes.getRequest();
    }

    // 获取当前请求用户的信息
    public static SysUser getCurrentUser() {
        HttpServletRequest request = getRequest();
        String token = request.getHeader(CommonConstants.FRONT_FIELD.AUTHORIZATION);

        JWT jwt_content = JWTUtil.parseToken(token);
        // 1 校验redis是否存在
        String user_id = jwt_content.getPayload("jti").toString();
        // 使用redis存储token
        String key = StrUtil.format("SysUser.{}", user_id);
        RBucket<Object> bucket = redissonClient.getBucket(key);
        if (!bucket.isExists()) {
            throw new AuthExecption("用户未登录");
        }
        // 2. 获取用户信息
        String user_str = bucket.get().toString();
        return JSONUtil.toBean(user_str, SysUser.class);
    }

    /**
     * 获取客户端ip
     */
    public static String getIpAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getRemoteHost();
    }

    public static Long getUserId() {
        SysUser user = getCurrentUser();
        return user.getId();
    }

    public static String getUserName() {
        SysUser user = getCurrentUser();
        return user.getName();
    }

    public static String getUserEmail() {
        SysUser user = getCurrentUser();
        return user.getEmail();
    }

    @PostConstruct
    void init() {
        redissonClient = SpringUtils.get(RedissonClient.class);
    }


}
