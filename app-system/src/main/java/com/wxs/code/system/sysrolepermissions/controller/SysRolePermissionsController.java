/*
 *  @description: SysRolePermissionsController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysrolepermissions.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.system.sysrolepermissions.entity.SysRolePermissions;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/system/sysrolepermissions")
@Tag(name = "角色权限表", description = "system模块-角色权限表")
public class SysRolePermissionsController extends BaseController<SysRolePermissions> {


}
