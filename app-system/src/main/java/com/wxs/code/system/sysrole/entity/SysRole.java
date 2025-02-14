/*
 *  @description: SysRole.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.sysrole.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@TableName("sys_role")
@EqualsAndHashCode(callSuper = false)
@Schema(description = "系统角色表")
public class SysRole extends BaseEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "roleName", description = "角色名称")
    private String roleName;

    @Schema(name = "roleCode", description = "角色编码")
    private String roleCode;

    @Schema(name = "createTime", description = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(name = "updateTime", description = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Schema(name = "createById", description = "")
    private Long createById;

    @Schema(name = "updateById", description = "")
    private Long updateById;

    @Schema(name = "createBy", description = "")
    private String createBy;

    @Schema(name = "updateBy", description = "")
    private String updateBy;

}
