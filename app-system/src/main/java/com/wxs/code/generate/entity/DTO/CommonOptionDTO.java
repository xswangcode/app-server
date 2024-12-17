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


import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * 代码生成的DTO
 */
@Data
@Builder
public class CommonOptionDTO {
    String table; // 表名
    String moduleName; // 模块名
    String packageName; // 包名，全链接
    String entityPackage; // entity 所属模块，目前有：biz,core,system
    String path; // 生成路径
    String author; // 作者
    String email; // 作者邮箱
    String version = "1.0"; // 版本号
    String remark; // 模块描述
    @Builder.Default
    Date time = new Date(); // 默认当前时间
    Map<String, Object> entityOption;
}
