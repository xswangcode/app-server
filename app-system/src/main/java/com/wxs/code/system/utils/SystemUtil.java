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

    private static ISysUserService userSvc;

    public static ISysUserService getUserSvc() {
        synchronized (SystemUtil.class) {
            if (userSvc == null)
                userSvc = SpringUtils.get(ISysUserService.class);
            if (userSvc == null)
                throw new SystemException("未找到用户服务");
        }
        return userSvc;
    }

    // 获取当前请求用户的信息
    public static SysUser getCurrentUser() {
        Long loginId = StpUtil.getLoginIdAsLong();
        return getUserSvc().getById(loginId);
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

}
