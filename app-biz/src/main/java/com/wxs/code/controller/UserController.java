package com.wxs.code.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.controller.BaseController;
import com.wxs.code.entity.biz.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dromara.hutool.core.date.DateField;
import org.dromara.hutool.core.date.DateTime;
import org.dromara.hutool.core.date.TimeUtil;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Tag(name = "用户接口", description = "BIZ模块-用户接口")
public class UserController extends BaseController<User> {
    /**
     * 私人密钥
     */
    @Value("${app.token.secretKey}")
    public String sign;
    @PostMapping("login")
    public String login(@RequestBody User user) {
        logger.info("用户名：[{}]", user.getName());
        logger.info("邮件：[{}]", user.getEmail());
        User dbu = baseService.getOne(Wrappers.lambdaQuery(user));
        Map<String, Object> map = new HashMap<>();
        // id-name-email
        map.put("id",dbu.getId());
        map.put("name",dbu.getName());
        map.put("email",dbu.getEmail());
        map.put("signAt", DateTime.now().getTime());

        logger.info(map.get("signAt").toString());
        map.put("X-Auth-Token", JWTUtil.createToken(map, sign.getBytes()));
        return JWTUtil.createToken(map, sign.getBytes());
    }

    @PostMapping("/jwttest")
    public Map<String, Object> test(String token) {
        logger.info("当前token为：[{}]", token);
        Map<String, Object> map = new HashMap<>();
        try {
//            JWT jwt = JWTUtil.parseToken(token);
            // 验证令牌
            boolean verify = JWTUtil.verify(token, sign.getBytes());
            if(verify){
                map.put("state", true);
                map.put("msg", "请求成功");
            }else{
                map.put("state", false);
                map.put("msg", "无效签名AAAA");
            }
            return map;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名！");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token无效！");
        }
        map.put("state", false);
        return map;
    }


}
