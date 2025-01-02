/*
 *  @description: SysUserServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysuser.service.Impl;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.sysuser.entity.DTO.SysUserRegisterDTO;
import com.wxs.code.system.sysuser.entity.SysUser;
import com.wxs.code.system.sysuser.service.ISysUserService;
import org.dromara.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends BaseService<SysUser> implements ISysUserService {

    @Override
    public RspMsg resetPassword(String userId, String oldPassword, String newPassword) {
        SysUser dbUser = getById(userId);
        if (dbUser == null)
            return RspMsg.error("用户不存在");
        // 验证原密码是否正确
        if (!dbUser.getPassword().equals(oldPassword)) {
            return RspMsg.error("旧密码不正确");
        }
        // 修改密码
        dbUser.setPassword(newPassword);
        updateById(dbUser);
        return RspMsg.OK("修改成功");
    }

    /**
     * 注册用户
     *
     * @return
     */
    @Override
    public RspMsg register(SysUserRegisterDTO dto) {
        // 字段是否为空
        boolean empty = dto.ifEmpty();
        if (empty) {
            return RspMsg.error("参数不能为空");
        }
        // 校验是否存在
        List<SysUser> dbUser = list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, dto.getName()).or().eq(SysUser::getEmail, dto.getEmail()));
        if (!dbUser.isEmpty())
            return RspMsg.error("该用户已经注册，使用邮箱登录");

        SysUser saveUser = SysUser.builder().name(dto.getName()).age(dto.getAge()).email(dto.getEmail()).password(dto.getPassword()).build();
        // 创建用户
        boolean saveEd = save(saveUser);
        if (!saveEd) {
            return RspMsg.error("注册失败");
        }
        return RspMsg.ok("注册成功");
    }

    @Override
    public SysUser getByName(String name) {
        List<SysUser> list = list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, name));
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public RspMsg<?> login(String name, String password) {
        List<SysUser> userList = list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, name).eq(SysUser::getPassword, password));
        if (userList.isEmpty()) {
            return RspMsg.error("用户名或密码错误");
        }
        SysUser user = userList.get(0);
        StpUtil.login(user.getId());
        return RspMsg.ok();
    }

    @Override
    public Boolean forgetPassword(String username, String password) {
        List<SysUser> list = list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, username));
        if (list.isEmpty()) {
            return false;
        }
        SysUser sysUser = list.get(0);
        boolean update = update(Wrappers.lambdaUpdate(SysUser.class).set(SysUser::getPassword, password).eq(SysUser::getId, sysUser.getId()));
        return update;
    }

    private String getPasswordByKey(String key, String password) {
        return SecureUtil.md5(key + password);
    }


}
