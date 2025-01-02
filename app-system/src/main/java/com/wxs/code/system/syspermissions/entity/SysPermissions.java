/*
 *  @description: SysPermissions.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.syspermissions.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@TableName("sys_permissions")
@Schema(description = "系统权限表")
public class SysPermissions extends BaseEntity {


        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Long id;

        @Schema(name = "code", description = "权限编码")
        private String code;

        @Schema(name = "name", description = "权限名称")
        private String name;

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
