package com.wxs.code.core.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.core.date.DateTime;
import org.dromara.hutool.core.date.TimeUtil;
import org.dromara.hutool.json.jwt.JWT;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Component
@Slf4j
public class AuthHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthHandlerInterceptor.class);
    /**
     * 私人密钥
     */
    @Value("${app.token.secretKey}")
    public String sign;

    /**
     * 刷新token时间,多久刷新一次token
     */
    @Value("${app.token.refreshTime}")
    public Long refreshTime;

    /**
     * 超期时间，超过指定时长，无法无感刷新
     */
    @Value("${app.token.expiresTime}")
    public Long expiresTime;

    @Value("${server.port}")
    public Long port;

    /**
     * 保存签名的头部字段
     */
    private static final String AUTHORIZATION = "X-Auth-Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        System.out.println(request.getRequestURI());
//        if (request.getRequestURI().equals("/v3/api-docs/default")) {
//            return true;
//        }
        // 1. 获取请求头中的  X-Auth-Token
        String token = request.getHeader(AUTHORIZATION);
        if (null == token || token.trim().isEmpty()) {
            return false;
        }

        logger.info("Token:{} ", token);

        //2. 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        boolean verify = JWTUtil.verify(token, sign.getBytes());

        //2.1  token 验证失败
        if (!verify) {
            return false;
        }
        // 2.2 获取原始内容
        JWT jwt_content = JWTUtil.parseToken(token);


        // 2.3 获取当前token可用时间
        long now = DateTime.now().getTime();
        long signAt = Long.parseLong(jwt_content.getPayloads().get("signAt").toString());

        long timeOfUse =  TimeUtil.between(TimeUtil.of(signAt),TimeUtil.of( now), ChronoUnit.SECONDS);

        logger.error("当前时间：{}   token加签时间：{}  可用时间：{}秒", DateTime.of(now),DateTime.of(signAt), timeOfUse);
        //3. 判断 token 是否过期
        if (timeOfUse < refreshTime) {
            log.error("token验证成功");
            return true;
        }
        if (timeOfUse >= refreshTime && timeOfUse < expiresTime) {
            //超过token刷新时间，刷新 token
            jwt_content.setPayload("signAt", DateTime.now().getTime());
            response.setHeader(AUTHORIZATION, jwt_content.sign());
            log.error("token无感刷新成功");
            return true;
        } else {
            //token过期就返回 token 无效.
            log.error("token失效啦");
            response.getOutputStream().write("token无效".getBytes());
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
