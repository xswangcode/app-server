package com.wxs.code.system.controller;


import com.wxs.code.core.controller.BaseController;
import com.wxs.code.entity.system.SysMenu;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("menu")
@RestController
@Tag(name = "菜单管理", description = "系统模块-菜单接口")
public class MenuController extends BaseController<SysMenu> {

}
