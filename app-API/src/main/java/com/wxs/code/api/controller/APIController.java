/*
 *  @description: APIController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/16 下午3:03
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.api.controller;


import com.wxs.code.api.entity.DTO.ApiRequestParam;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.service.ApiBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Tag(name = "API接口", description = "API接口")
public class APIController {


    @SuppressWarnings("rawtypes")
    @PostMapping(value = "in")
    @Operation(summary = "API接口入口", description = "API接口入参")
    RspMsg apiIn(@RequestBody ApiRequestParam param, HttpServletRequest request) {

        ApiBaseService svc = ApiBaseService.getServiceByApi(param.getApi());
        Object result = null;
        if (svc != null) {
            result = svc.process(param.getData());
        } else {
            return RspMsg.error(param.getApi() + "找不到对应的服务类");
        }
        return RspMsg.OK(result);
    }
}
