/*
 *  @description: SysUserRoleController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysuserrole.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.system.sysuserrole.entity.SysUserRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/system/sysuserrole")
@Tag(name = "用户角色表", description = "system模块-用户角色表")
public class SysUserRoleController extends BaseController<SysUserRole> {


}
