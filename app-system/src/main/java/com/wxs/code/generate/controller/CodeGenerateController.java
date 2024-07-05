/*
 *  @description: CodeGenerateController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/7/5 下午5:59
 *  @date: 2024-7-5 17:59
 *
 */

package com.wxs.code.generate.controller;


import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.ext.spring.JFinalViewResolver;
import com.wxs.code.entity.generate.DTO.CommonOptionDTO;
import com.wxs.code.generate.service.CodeGenerateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dromara.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "代码生成", description = "系统模块-代码生成接口")
@RequestMapping("/code/generate")
public class CodeGenerateController {

    @Autowired
    JFinalViewResolver jFinalViewResolver;

    @Autowired
    CodeGenerateService codeSvc;

    @Operation(summary = "测试整个文件夹")
    @GetMapping("test")
    public RspMsg<?> test() {
        CommonOptionDTO ta = CommonOptionDTO.builder()
                .moduleName("Test")
                .packageName("com.wxs.code.test")
                .email("xswang.code@126.com")
                .path("D://tmp//")
                .author("xswang")
                .table("test")
                .version("1.0.0")
                .remark("这是一个测试")
                .build();
        codeSvc.renderFolder("one", BeanUtil.beanToMap(ta), "D://tmp//");
        return RspMsg.ok();
    }


}
