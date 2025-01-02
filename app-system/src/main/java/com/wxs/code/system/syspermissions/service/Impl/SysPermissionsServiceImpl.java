/*
 *  @description: SysPermissionsServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.syspermissions.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.syspermissions.entity.SysPermissions;
import com.wxs.code.system.syspermissions.service.ISysPermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionsServiceImpl extends BaseService<SysPermissions> implements ISysPermissionsService {

    /**
     * @param ids
     * @return
     */
    @Override
    public List<SysPermissions> getByIds(List<Long> ids) {
        return list(Wrappers.lambdaQuery(SysPermissions.class).in(SysPermissions::getId, ids));
    }

}
