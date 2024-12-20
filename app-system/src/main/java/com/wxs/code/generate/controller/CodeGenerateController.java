/*
 *  @description: CodeGenerateController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:26
 *  @date: 2024-12-20 10:28
 *
 */

package com.wxs.code.generate.controller;


import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.ext.spring.JFinalViewResolver;
import com.wxs.code.generate.entity.DTO.CommonOptionDTO;
import com.wxs.code.generate.entity.DTO.DB.TableField;
import com.wxs.code.generate.service.CodeGenerateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

//      查询表结构
        List<TableField> fields = codeSvc.getTableFields("student");

        CommonOptionDTO ta = CommonOptionDTO.builder()
                .moduleName("TaskConfig")
                .packageName("com.wxs.code")
                .entityPackage("schedule")
                .email("xswang.code@126.com")
//                .path("D://tmp//")
                .path("D:\\code\\git\\app-server\\app-system\\src\\main\\java\\")
                .author("xswang")
                .table("task_config")
                .version("1.0.0")
                .remark("定时任务配置表")
                .entityOption(Map.of("fields", fields, "isCoreEntity", false))
                .build();
        codeSvc.renderFolder("one", ta);
        return RspMsg.ok();
    }


}
