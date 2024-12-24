/*
 *  @description: SysUserRoleServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysuserrole.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.sysuserrole.entity.SysUserRole;
import com.wxs.code.system.sysuserrole.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends BaseService<SysUserRole> implements ISysUserRoleService {

    @Override
    public List<SysUserRole> getByUserId(Long userId) {
        List<SysUserRole> list = list(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, userId));
        return list;
    }
}
