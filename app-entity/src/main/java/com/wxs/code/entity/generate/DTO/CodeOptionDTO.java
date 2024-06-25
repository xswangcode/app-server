/*
 *  @description: CodeOptionDTO.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午9:48
 *  @date: 2024-6-25 10:51
 *
 */

package com.wxs.code.entity.generate.DTO;


import lombok.Data;

/**
 * 代码生成的DTO
 */
@Data
public class CodeOptionDTO {
    String table; // 表名
    String className; // 类名
    String packageName; // 包名
    String author; // 作者
    String remark; // 描述
}
