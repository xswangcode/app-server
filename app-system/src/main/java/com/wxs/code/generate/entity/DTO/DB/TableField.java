/*
 *  @description: TableField.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.generate.entity.DTO.DB;


import com.wxs.code.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class TableField extends BaseEntity {
    String field;
    String type;
    String isNull;
    String key;
    String defaultVal;
    String extra;
    String comment;
}