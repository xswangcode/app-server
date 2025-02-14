/*
 *  @description: SysDict.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025-02-14 15:58:29
 *  @date: 2025-02-14 15:58:29
 *
 */

package com.wxs.code.system.sysdict.entity;

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
@TableName("sys_dict")
@Schema(description = "数据字典主表")
public class SysDict extends BaseEntity{


        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Long id;

        @Schema(name = "code", description = "字典编码")
        private String code;

        @Schema(name = "name", description = "字典名称")
        private String name;

        @Schema(name = "remark", description = "备注")
        private String remark;

        @Schema(name = "status", description = "状态 0:禁用 1:启用")
        private Boolean status;

        @Schema(name = "sort", description = "排序")
        private Integer sort;

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
