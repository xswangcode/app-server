/*
 *  @description: ISysUserService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.system.entity.DTO.SysUserDTO;
import com.wxs.code.system.entity.SysUser;

public interface ISysUserService extends IService<SysUser> {

    RspMsg<?> resetPassword(String userId, String oldPassword, String newPassword);

    RspMsg<?> register(SysUserDTO user);




}
