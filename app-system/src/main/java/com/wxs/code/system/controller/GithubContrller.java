package com.wxs.code.system.controller;


import com.wxs.code.core.api.VO.RspMsg;
import jakarta.validation.constraints.NotBlank;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("github")
@Validated
public class GithubContrller {


    @Value("${app.login.github.client_id}")
    String client_id;
    @Value("${app.login.github.client_secret}")
    String client_secret;

    RestTemplate restTemplate = new RestTemplate();

    /**
     * 登录流程（需要提前配置GitHub的第三方网站配置）
     * 1. 前端发起登录请求   <a href="https://github.com/login/oauth/authorize?client_id=你自己的客户端id"> github</a>
     * 2. 获取到回调接口中的code, 调用login/oauth/access_token 接口，获取返回token
     * 3. 根据token调用接口api.github.com/user 获取用户信息
     *
     * @param code GitHub回调时候传递的编码
     * @return
     */
    @GetMapping("login")
    public RspMsg<?> githubLogin(@NotBlank String code) {
        String access_token_url = StrUtil.concat(false,"https://github.com/login/oauth/access_token?code=", code, "&client_id=", client_id, "&client_secret=", client_secret);
        ResponseEntity<String> rsp = restTemplate.getForEntity(access_token_url, String.class);
        String[] items = Objects.requireNonNull(rsp.getBody()).split("&");
        String token = "";
        for (String item : items) {
            if (item.startsWith("access_token")) {
                String[] tmp = item.split("=");
                token = tmp[1];
            }
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        rsp = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, new HttpEntity(headers), String.class);
        return RspMsg.OK("使用GitHub登录成功", JSONUtil.toBean(rsp.getBody(), Map.class));
    }
}
