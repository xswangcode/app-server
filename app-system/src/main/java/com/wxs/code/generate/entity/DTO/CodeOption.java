/*
 *  @description: CommonOptionDTO.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.entity.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 代码生成的DTO
 */
@Data
@Builder
@Schema(description = "代码生成参数实体类")
public class CodeOption {
    @Schema(name = "table", description = "表名,eg: task_config", defaultValue = "task_config")
    String table; // 表名
    //自动通过表名转换，不需要传入
    @Schema(name = "moduleName", description = "模块名，自动通过表名转换，不需要传入,eg: TaskConfig")
    String moduleName; // 模块名
    @Schema(name = "packageName", description = "包名,eg: com.wxs.code", defaultValue = "com.wxs.code")
    String packageName; // 包名
    @Schema(name = "entityPackage", description = "包名下的模块,eg: system", defaultValue = "system")
    String entityPackage; // entity 所属模块，目前有：biz,core,system
    @Schema(name = "path", description = "路径,eg: /Users/xswang/Desktop/test", defaultValue = "/**/app-system/src/main/java/")
    String path; // 生成路径
    @Schema(name = "author", description = "路径,eg: xswang", defaultValue = "xswang")
    String author; // 作者
    @Schema(name = "email", description = "邮箱,eg: wxs_code@126.com", defaultValue = "wxs_code@126.com")
    String email; // 作者邮箱
    @Schema(name = "version", description = "版本号,eg: 1.0", defaultValue = "1.0")
    @Builder.Default
    String version = "1.0"; // 版本号
    @Schema(name = "remark", description = "备注,eg: 模块描述")
    String remark; // 模块描述
    @Builder.Default
    Date time = new Date(); // 默认当前时间
    EntityOption entityOption;
}
