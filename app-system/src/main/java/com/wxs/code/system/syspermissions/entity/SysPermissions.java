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
import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@TableName("sys_permissions")
@Schema(description = "权限表")
@EqualsAndHashCode(callSuper = true)
public class SysPermissions extends CoreEntity {

    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "code", description = "权限编码")
    private String code;

    @Schema(name = "name", description = "权限名称")
    private String name;
}
