package com.wxs.code.core.utils;

import com.wxs.code.core.entity.system.SysUser;
import com.wxs.code.core.exception.AuthExecption;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.json.JSONUtil;
import org.dromara.hutool.json.jwt.JWT;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class SystemUtil {
    private static final RedissonClient redissonClient = SpringUtils.get(RedissonClient.class);

    // 获取当前登录用户的信息
    public static SysUser getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse()
        String header_token = request.getHeader("X-Auth-Token");
        JWT jwt_content = JWTUtil.parseToken(header_token);
        // 1 校验redis是否存在
        String user_id = jwt_content.getPayload("jti").toString();
        // 使用redis存储token
        String key = StrUtil.format("SysUser.{}", user_id);
        RBucket<Object> bucket = redissonClient.getBucket(key);
        if (!bucket.isExists()) {
            throw new AuthExecption("token无效,请重新登录");
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
}