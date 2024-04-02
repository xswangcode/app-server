package com.wxs.code.system.utils;

import com.wxs.code.core.constant.CommonConstants;
import com.wxs.code.core.exception.AuthExecption;
import com.wxs.code.entity.system.SysUser;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.hutool.json.JSONUtil;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
public class SystemUtils {

    @Autowired
    RedissonClient redissonClient;

    private HttpServletRequest request;
    private static String token;
    private  static SysUser user;

    public SystemUtils() {
        ServletRequestAttributes requestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            HttpServletRequest request = requestAttributes.getRequest();
            token = request.getHeader(CommonConstants.FRONT_FIELD.AUTHORIZATION);
            getCurrentUser();
        }
    }

    public SystemUtils(HttpServletRequest request) {
        if(request!=null) {
            token = request.getHeader(CommonConstants.FRONT_FIELD.AUTHORIZATION);
            getCurrentUser();
        }
    }

    private SysUser getCurrentUser() {
        if (user == null) {
            String json_user = redissonClient.getBucket(token).get().toString();
            user = JSONUtil.toBean(json_user, SysUser.class);
        }
        if(user == null)
            throw new AuthExecption("用户未登录");
        return user;
    }

    public static Long getUserId(){
        return user.getId();
    }

    public static String getUserName(){
        return user.getName();
    }
    public static String getUserEmail(){
        return user.getEmail();
    }
}
