package com.wxs.code.core.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.entity.system.DTO.SysUserDTO;
import com.wxs.code.core.entity.system.SysUser;

public interface ISysUserService extends IService<SysUser> {

    RspMsg<?> resetPassword(String userId, String oldPassword, String newPassword);

    RspMsg<?> register(SysUserDTO user);




}
