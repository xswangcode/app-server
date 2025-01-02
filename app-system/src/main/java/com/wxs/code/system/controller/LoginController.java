/*
 *  @description: LoginController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025/1/2 上午9:43
 *  @date: 2025-1-2 9:43
 *
 */

package com.wxs.code.system.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.system.sysuser.entity.DTO.SysUserRegisterDTO;
import com.wxs.code.system.sysuser.service.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@OpenAPI30
@Tag(name = "登录接口", description = "登录接口")
public class LoginController {

    @Autowired
    ISysUserService userSvc;

    /**
     * @return
     */
    @PostMapping()
    @Operation(summary = "系统账户登录")
    public RspMsg<?> login(@Schema(name = "用户名或邮箱") String username,
                           @Schema(name = "密码") String password) {
        return userSvc.login(username, password);
    }

    @GetMapping("/register")
    @Operation(summary = "系统账户注册")
    public RspMsg<?> register(SysUserRegisterDTO user) {
        RspMsg<?> register = userSvc.register(user);
        return register;
    }

    @PostMapping("/forgetpassword")
    @Operation(summary = "忘记密码重置")
    public RspMsg<?> forgetpassword(@Schema(name = "用户名或邮箱") String username,
                                    @Schema(name = "密码") String password) {
        boolean result = userSvc.forgetPassword(username, password);
        return RspMsg.response(result);
    }

    @Operation(summary = "登出系统账户")
    @RequestMapping("logout")
    public RspMsg logout() {
        StpUtil.logout();
        return RspMsg.ok();
    }


}
