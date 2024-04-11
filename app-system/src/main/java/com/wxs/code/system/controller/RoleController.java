package com.wxs.code.system.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.entity.system.SysRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Tag(name = "角色接口", description = "系统模块-角色接口")
public class RoleController extends BaseController<SysRole> {
}
