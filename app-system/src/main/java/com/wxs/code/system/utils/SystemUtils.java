package com.wxs.code.system.utils;

import com.wxs.code.core.constant.CommonConstants;
import com.wxs.code.core.entity.system.SysUser;
import com.wxs.code.core.exception.AuthExecption;
import com.wxs.code.core.utils.SpringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.dromara.hutool.json.JSONUtil;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
public class SystemUtils {

    static RedissonClient redissonClient;

    @NotNull
    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return requestAttributes.getRequest();
        }
        throw new RuntimeException("找不到HttpServletRequest对象");
    }

    private static SysUser getCurrentUser() {
        HttpServletRequest request = getRequest();
        String token = request.getHeader(CommonConstants.FRONT_FIELD.AUTHORIZATION);
        String json_user = redissonClient.getBucket(token).get().toString();
        SysUser user = JSONUtil.toBean(json_user, SysUser.class);
        if (user == null)
            throw new AuthExecption("用户未登录");
        return user;
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
