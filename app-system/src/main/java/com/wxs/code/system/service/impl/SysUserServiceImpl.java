package com.wxs.code.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.entity.system.SysUser;
import com.wxs.code.entity.system.SysUserPassword;
import com.wxs.code.system.entity.DTO.SysUserDTO;
import com.wxs.code.system.service.ISysUserPasswordService;
import com.wxs.code.system.service.ISysUserService;
import org.dromara.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements ISysUserService {

    @Autowired
    ISysUserPasswordService upSvc;

    @Override
    public RspMsg resetPassword(String userId, String oldPassword, String newPassword) {
        SysUser dbUser = getById(userId);
        if(dbUser == null)
            return RspMsg.error("用户不存在");
        // 验证原密码是否正确
        SysUserPassword dbPwd = upSvc.getOne(Wrappers.lambdaQuery(SysUserPassword.class).eq(SysUserPassword::getSysUserId, userId));
        String oldKey = getPasswordByKey(dbUser.getCreateTime().toString(), oldPassword);
        if(!dbPwd.getPassword().equals(oldKey)){
            return RspMsg.error("旧密码不正确");
        }
        // 修改密码
        dbPwd.setPassword(getPasswordByKey(dbUser.getCreateTime().toString(),newPassword));
        upSvc.updateById(dbPwd);
        return RspMsg.OK("修改成功");
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public RspMsg register(SysUserDTO dto) {
        // 字段是否为空
        boolean empty = dto.ifEmpty();
        if(empty){
            return RspMsg.error("参数不能为空");
        }


        // 校验是否存在
        SysUser dbUser = getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, dto.getName()).eq(SysUser::getEmail, dto.getEmail()));
        if(dbUser != null)
            return RspMsg.error("该用户已经注册，使用邮箱登录");

        SysUser saveUser = SysUser.builder().name(dto.getName()).age(dto.getAge()).email(dto.getEmail()).build();
        // 创建用户
        boolean saveEd = save(saveUser);
        if(!saveEd){
            return RspMsg.error("注册失败");
        }
        saveUser = getById(saveUser.getId());
        SysUserPassword saveUserPassword = SysUserPassword.builder().sysUserId(saveUser.getId()).password(getPasswordByKey(saveUser.getCreateTime().toString(),dto.getPassword())).build();
        // 创建密码
        saveEd = upSvc.save(saveUserPassword);
        if(!saveEd){
            return RspMsg.error("注册失败");
        }
        return RspMsg.ok("注册成功");
    }

    private String getPasswordByKey(String key,String password){
        return SecureUtil.md5(key+password);
    }



}