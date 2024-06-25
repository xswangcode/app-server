/*
 *  @description: AuthHandlerInterceptor.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/20 下午4:18
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.interceptor;

import com.wxs.code.core.config.AuthConfig;
import com.wxs.code.core.exception.AuthExecption;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.core.date.DateTime;
import org.dromara.hutool.core.date.TimeUtil;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.json.jwt.JWT;
import org.dromara.hutool.json.jwt.JWTUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.wxs.code.core.constant.CommonConstants.FRONT_FIELD.AUTHORIZATION;


@Component
@Slf4j
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    AuthConfig authConfig;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;


    /**
     * 校验token方法
     * 从request请求头中获取token，校验超期时间。
     * 未超期: pass
     * 未过期，但可以刷新： 重新设置超期时间，刷新token,放在response_header中
     * 超过最大期限： 失败
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 1. 获取请求头中的  X-Auth-Token
        String token = request.getHeader(AUTHORIZATION);
        if (null == token || token.trim().isEmpty()) {
            throw new AuthExecption("token无效,不能为空");
        }

        log.info("Token:{} ", token);

        //2. 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        boolean verify = JWTUtil.verify(token, authConfig.JWT_SIGNER);

        //2.1  token 验证失败
        if (!verify) {
            throw new AuthExecption("token无效,验证失败");
        }
        // 2.2 获取原始内容
        JWT jwt_content = JWTUtil.parseToken(token);
        // 2.2.1 校验redis是否存在
        String user_id = jwt_content.getPayload("jti").toString();
        // 使用redis存储token
        String key = StrUtil.format("SysUser.{}", user_id);
        RBucket<Object> bucket = redissonClient.getBucket(key);
        if (!bucket.isExists()) {
            throw new AuthExecption("token无效,请重新登录");
        }
        // 2.3 获取当前token可用时间
        long now = DateTime.now().getTime();
        long signAt = Long.parseLong(jwt_content.getPayloads().get("iat").toString());

        long timeOfUse = TimeUtil.between(TimeUtil.of(signAt), TimeUtil.of(now), ChronoUnit.SECONDS);

        log.error("当前时间：{}   token加签时间：{}  已经使用时间：{}秒", DateTime.of(now), DateTime.of(signAt), timeOfUse);
        //3. 判断 token 是否过期
        if (timeOfUse < authConfig.refreshTime) {
            log.error("token验证成功");
            return true;
        }

        if (timeOfUse >= authConfig.refreshTime && timeOfUse < authConfig.expiresTime) {
            //超过token刷新时间，刷新 token
            jwt_content.setPayload("iat", DateTime.now().getTime());
            String new_token = JWTUtil.createToken(jwt_content.getPayloads(), authConfig.JWT_SIGNER);
            //更新 redis 中的 token, 不会更新用户信息
            redissonClient.getBucket(key).expire(Duration.ofSeconds(authConfig.expiresTime));
            response.setHeader(AUTHORIZATION, new_token);
            log.error("token无感刷新成功,最新token:{}", new_token);
            return true;
        } else {
            //token过期就返回 token 无效.
            log.error("token失效啦");
            throw new AuthExecption("token无效");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
