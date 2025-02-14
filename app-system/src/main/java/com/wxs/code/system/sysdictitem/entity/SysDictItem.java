/*
 *  @description: SysDictItem.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025-02-14 15:59:26
 *  @date: 2025-02-14 15:59:26
 *
 */

package com.wxs.code.system.sysdictitem.entity;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@ToString
@TableName("sys_dict_item")
@Schema(description = "数据字典子表")
public class SysDictItem extends BaseEntity{


        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Long id;

        @Schema(name = "dictCode", description = "父字典编码")
        private String dictCode;

        @Schema(name = "pid", description = "父字典编码id")
        private Long pid;

        @Schema(name = "code", description = "字典编码")
        private String code;

        @Schema(name = "name", description = "字典名称")
        private String name;

        @Schema(name = "value1", description = "值1")
        private String value1;

        @Schema(name = "value2", description = "值2")
        private String value2;

        @Schema(name = "value3", description = "值3")
        private String value3;

        @Schema(name = "value4", description = "值4")
        private String value4;

        @Schema(name = "value5", description = "值5")
        private String value5;

        @Schema(name = "value6", description = "值6")
        private String value6;

        @Schema(name = "status", description = "状态 0:禁用 1:启用")
        private Boolean status;

        @Schema(name = "sort", description = "排序")
        private Integer sort;

        @Schema(name = "remark", description = "备注")
        private String remark;

        @Schema(name = "createTime", description = "创建时间")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;

        @Schema(name = "updateTime", description = "更新时间")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updateTime;

        @Schema(name = "createById", description = "创建人id")
        private Long createById;

        @Schema(name = "updateById", description = "更新人id")
        private Long updateById;

        @Schema(name = "createBy", description = "创建人")
        private String createBy;

        @Schema(name = "updateBy", description = "更新人")
        private String updateBy;

}
