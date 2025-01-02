/*
 *  @description: SysRolePermissionsServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */



package com.wxs.code.system.sysrolepermissions.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.sysrolepermissions.entity.SysRolePermissions;
import com.wxs.code.system.sysrolepermissions.service.ISysRolePermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRolePermissionsServiceImpl extends BaseService<SysRolePermissions> implements ISysRolePermissionsService {

    /**
     * @param roleIds
     * @return
     */
    @Override
    public List<SysRolePermissions> getByRoleIds(List<Long> roleIds) {
        List<SysRolePermissions> role_permissions = list(Wrappers.lambdaQuery(SysRolePermissions.class).in(SysRolePermissions::getRoleId, roleIds));
        return role_permissions;
    }
}
