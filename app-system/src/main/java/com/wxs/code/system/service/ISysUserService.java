/*
 *  @description: ISysUserService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午9:53
 *  @date: 2024-6-25 10:51
 *
 */

package com.wxs.code.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.entity.system.DTO.SysUserDTO;
import com.wxs.code.entity.system.SysUser;

public interface ISysUserService extends IService<SysUser> {

    RspMsg<?> resetPassword(String userId, String oldPassword, String newPassword);

    RspMsg<?> register(SysUserDTO user);




}
