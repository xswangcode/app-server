/*
 *  @description: PersimssionStpInterface.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025/1/2 上午10:49
 *  @date: 2025-1-2 10:49
 *
 */

package com.wxs.code.system.components;


import cn.dev33.satoken.stp.StpInterface;
import com.wxs.code.constant.RedisConstants;
import com.wxs.code.core.utils.ConfigUtil;
import com.wxs.code.system.syspermissions.entity.SysPermissions;
import com.wxs.code.system.syspermissions.service.ISysPermissionsService;
import com.wxs.code.system.sysrole.entity.SysRole;
import com.wxs.code.system.sysrole.service.ISysRoleService;
import com.wxs.code.system.sysrolepermissions.entity.SysRolePermissions;
import com.wxs.code.system.sysrolepermissions.service.ISysRolePermissionsService;
import com.wxs.code.system.sysuserrole.entity.SysUserRole;
import com.wxs.code.system.sysuserrole.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限认证
 */

@Component
public class PersimssionStpInterface implements StpInterface {

    @Autowired
    private ISysUserRoleService userRoleSvc;

    @Autowired
    private ISysRoleService roleSvc;

    @Autowired
    private ISysPermissionsService permissionsSvc;

    @Autowired
    private ISysRolePermissionsService rolePermissionsSvc;

    @Override
    @Cacheable(value = RedisConstants.GET_PERMISSION_LIST_KEY, key = "#loginId + ':' + #loginType")
    public List<String> getPermissionList(Object loginId, String loginType) {
        if (ConfigUtil.appConfig().getDebug().getEnable())
            return List.of("*");
        List<SysUserRole> userRoles = userRoleSvc.getByUserId(Long.valueOf(loginId.toString()));
        if (userRoles.isEmpty()) {
            return Collections.emptyList();
        }
        List<SysRolePermissions> role_permissions = rolePermissionsSvc.getByRoleIds(userRoles.stream().map(SysUserRole::getId).toList());
        List<SysPermissions> permissions = permissionsSvc.getByIds(role_permissions.stream().map(SysRolePermissions::getPermissionsId).toList());
        List<String> result = permissions.stream().map(SysPermissions::getCode).collect(Collectors.toList());
        return result;
    }

    @Override
    @Cacheable(value = RedisConstants.GET_ROLE_LIST_KEY, key = "#loginId + ':' + #loginType")
    public List<String> getRoleList(Object loginId, String loginType) {
        if (ConfigUtil.appConfig().getDebug().getEnable())
            return List.of("*");

        List<SysUserRole> userRoles = userRoleSvc.getByUserId(Long.valueOf(loginId.toString()));
        if (userRoles.isEmpty()) {
            return Collections.emptyList();
        }
        List<SysRole> roles = roleSvc.getByIds(userRoles.stream().map(SysUserRole::getRoleId).toList());
        List<String> roleCodes = roles.stream().map(SysRole::getRoleCode).collect(Collectors.toList());

        return roleCodes;
    }
}
