/*
 *  @description: SystemUtil.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.1
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.system.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.wxs.code.core.exception.SystemException;
import com.wxs.code.core.utils.SpringUtils;
import com.wxs.code.system.sysuser.entity.SysUser;
import com.wxs.code.system.sysuser.service.ISysUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class SystemUtil {

    public static ISysUserService getUserSvc() {
        ISysUserService userSvc = UserSvcHolder.INSTANCE;
        if (userSvc == null) {
            throw new SystemException("未找到用户服务");
        }
        return userSvc;
    }

    // 获取当前请求用户的信息
    public static SysUser getCurrentUser() {
        Long loginId = StpUtil.getLoginIdAsLong();
        if (loginId == null) {
            return null;
        }
        return getUserSvc().getById(loginId);
    }

    public static Long getUserId() {
        SysUser user = getCurrentUser();
        return user != null ? user.getId() : null;
    }

    /**
     * 获取客户端ip
     */
    public static String getIpAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getRemoteHost();
    }

    /**
     * 获取当次请求的接口地址
     */
    public static String getRequestPath() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getQueryString() != null ? request.getRequestURL() + "?" + request.getQueryString() : request.getRequestURL().toString();
    }

    public static String getUserName() {
        SysUser user = getCurrentUser();
        return user != null ? user.getName() : null;
    }

    public static String getUserEmail() {
        SysUser user = getCurrentUser();
        return user != null ? user.getEmail() : null;
    }

    /**
     *
     */
    /**
     * 将类名转换成下划线格式
     *
     * @param className the class name to convert
     * @return the underscore formatted string
     */
    public static String toUnderscoreFormat(String className) {
        if (className == null || className.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(className.charAt(0)));

        for (int i = 1; i < className.length(); i++) {
            char currentChar = className.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                sb.append('_').append(Character.toLowerCase(currentChar));
            } else {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    private static class UserSvcHolder {
        private static final ISysUserService INSTANCE = SpringUtils.get(ISysUserService.class);
    }

}
