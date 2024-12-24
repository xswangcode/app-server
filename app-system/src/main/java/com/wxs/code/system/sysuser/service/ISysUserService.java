/*
 *  @description: ISysUserService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:39
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysuser.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.system.sysuser.entity.DTO.SysUserDTO;
import com.wxs.code.system.sysuser.entity.SysUser;


public interface ISysUserService extends IService<SysUser> {
    RspMsg<?> resetPassword(String userId, String oldPassword, String newPassword);

    RspMsg<?> register(SysUserDTO user);

    SysUser getByName(String name);
}
