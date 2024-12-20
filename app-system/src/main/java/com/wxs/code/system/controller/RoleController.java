/*
 *  @description: RoleController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.controller;

import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.entity.SysRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Tag(name = "角色接口", description = "系统模块-角色接口")
public class RoleController extends CoreController<SysRole> {
}
