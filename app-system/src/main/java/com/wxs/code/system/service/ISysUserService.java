package com.wxs.code.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.entity.system.SysUser;
import com.wxs.code.system.entity.DTO.SysUserDTO;

public interface ISysUserService extends IService<SysUser> {

    RspMsg<?> resetPassword(String userId, String oldPassword, String newPassword);

    RspMsg<?> register(SysUserDTO user);




}
