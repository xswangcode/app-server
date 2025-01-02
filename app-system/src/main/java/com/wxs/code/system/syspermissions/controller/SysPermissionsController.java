/*
 *  @description: SysPermissionsController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.syspermissions.controller;

import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.syspermissions.entity.SysPermissions;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/system/syspermissions")
@Tag(name = "权限表", description = "system模块-权限表")
public class SysPermissionsController extends CoreController<SysPermissions> {


}
