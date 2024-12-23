/*
 *  @description: SysUserController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysuser.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.BaseController;
import com.wxs.code.system.sysuser.entity.DTO.SysUserDTO;
import com.wxs.code.system.sysuser.entity.SysUser;
import com.wxs.code.system.sysuser.service.ISysUserService;
import com.wxs.code.system.utils.SystemUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.hutool.core.collection.CollUtil;
import org.dromara.hutool.core.date.DateTime;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.json.JSONUtil;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.dromara.hutool.json.jwt.signers.JWTSignerUtil;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@OpenAPI30
@RestController
@RequestMapping("/system/sysuser")
@Tag(name = "系统用户表", description = "system模块-系统用户表")
public class SysUserController extends BaseController<SysUser> {
    /**
     * 私人密钥
     */
    @Value("${app.token.secretKey}")
    public String sign;
    /**
     * 超期时间，超过指定时长，无法无感刷新
     */
    @Value("${app.token.expiresTime}")
    public Long expiresTime;
    @Autowired
    ISysUserService baseService;
    @Autowired
    RedissonClient redissonClient;

    @PostMapping("login")
    @Operation(summary = "系统账户登录")
    public RspMsg<?> login(String name, String password) {
        if (!StrUtil.isAllNotEmpty(name, password)) {
            return RspMsg.error("用户名和密码不能为空");
        }
        //todo 密码加密
        List<SysUser> dbuList = baseService.list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getName, password).eq(SysUser::getPassword, password));
        if (CollUtil.isEmpty(dbuList)) {
            dbuList = baseService.list(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getEmail, password).eq(SysUser::getPassword, password));
        }

        if (CollUtil.isEmpty(dbuList)) {
            return RspMsg.error("账户或密码错误");
        }

        SysUser dbu = dbuList.getFirst();
        Map<String, Object> map = new HashMap<>();
        // id-name-email
        map.put("iss", sign);
        map.put("name", dbu.getName());
        map.put("email", dbu.getEmail());
        map.put("jti", dbu.getId());
        map.put("iat", DateTime.now().getTime());
        logger.info(map.get("iat").toString());
        String token = JWTUtil.createToken(map, JWTSignerUtil.hs512(sign.getBytes()));
        // 使用redis存储token
        String key = StrUtil.format("SysUser.{}", dbu.getId());
        redissonClient.getBucket(key).set(JSONUtil.toJsonStr(dbu), Duration.ofSeconds(expiresTime));
        return RspMsg.ok(token);
    }

    @PostMapping("/jwttest")
    public String test(HttpServletRequest request) {
        logger.info("当前token为：[{}]", request.getHeader("X-Auth-Token"));
        System.out.println(SystemUtil.getUserEmail());
        return request.getHeader("X-Auth-Token");
    }


    /**
     * 用户注册功能
     *
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public RspMsg register(SysUserDTO dto) {
        return baseService.register(dto);
    }


}
