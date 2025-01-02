/*
 *  @description: SysRoleServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */



package com.wxs.code.system.sysrole.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.sysrole.entity.SysRole;
import com.wxs.code.system.sysrole.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseService<SysRole> implements ISysRoleService {

    /**
     * @param ids
     * @return
     */
    @Override
    public List<SysRole> getByIds(List<Long> ids) {
        List<SysRole> roles = list(Wrappers.lambdaQuery(SysRole.class).in(SysRole::getId, ids));
        return roles;
    }
}
