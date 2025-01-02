/*
 *  @description: CodeGenerateController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:41
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.generate.controller;


import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.ext.spring.JFinalViewResolver;
import com.wxs.code.generate.directive.TransformedIntoSmallHumpNomenclatureDirective;
import com.wxs.code.generate.entity.DTO.CodeOption;
import com.wxs.code.generate.entity.DTO.DB.TableField;
import com.wxs.code.generate.entity.DTO.EntityOption;
import com.wxs.code.generate.service.CodeGenerateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "代码生成", description = "系统模块-代码生成接口")
@RequestMapping("/code/generate")
public class CodeGenerateController {

    @Autowired
    JFinalViewResolver jFinalViewResolver;

    @Autowired
    CodeGenerateService codeSvc;

    @Operation(summary = "生成代码")
    @PostMapping("codegengerate")
    public RspMsg<?> test(CodeOption dto) {

        // 查询表结构
        List<TableField> fields = codeSvc.getTableFields(dto.getTable());

        EntityOption option = EntityOption.builder().fields(fields).build();

        dto.setTable(dto.getTable().toLowerCase());
        // 数据库表名转成大驼峰命名法
        String _up = TransformedIntoSmallHumpNomenclatureDirective.transformToSmall(dto.getTable());
        String up = String.valueOf(_up.toCharArray()[0]).toUpperCase() + _up.substring(1);

        dto.setModuleName(up);
        dto.setEntityOption(option);

        /**
         * table: sys_permissions
         * moduleName: SysPermissions
         * packageName: com.wxs.code
         * entityPackage: system
         * path: D:\\code\\git\\app-server\\app-system\\src\\main\\java\\
         * author: xswang
         * email: wxs_code@126.com
         * version: 1.0
         * remark: 权限表
         * time:
         * fields:
         * isCoreEntity: true
         */
        codeSvc.renderFolder("one", dto);
        return RspMsg.ok();
    }


}
