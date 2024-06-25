/*
 *  @description: CommonOptionDTO.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 下午5:04
 *  @date: 2024-6-25 18:2
 *
 */

package com.wxs.code.entity.generate.DTO;


import lombok.Builder;
import lombok.Data;

/**
 * 代码生成的DTO
 */
@Data
@Builder
public class CommonOptionDTO {
    String table; // 表名
    String moduleName; // 模块名
    String packageName; // 包名，全链接
    String path; // 生成路径
    String author; // 作者
    String email; // 作者邮箱
    String version = "1.0"; // 版本号
    String remark; // 模块描述
}
