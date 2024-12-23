/*
 *  @description: SysRolePermissions.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.sysrolepermissions.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@TableName("sys_role_permissions")
@Schema(description = "角色权限表")
@EqualsAndHashCode(callSuper = true)
public class SysRolePermissions extends BaseEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "roleId", description = "角色id")
    private Long roleId;

    @Schema(name = "permissionsId", description = "权限id")
    private Long permissionsId;

}
