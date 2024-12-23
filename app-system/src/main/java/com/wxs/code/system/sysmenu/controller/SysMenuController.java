/*
 *  @description: SysMenuController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.sysmenu.controller;

import com.wxs.code.core.annotation.AutoLog;
import com.wxs.code.core.annotation.HasPermissions;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.constant.LogConstant;
import com.wxs.code.core.controller.BaseController;
import com.wxs.code.system.sysmenu.entity.SysMenu;
import com.wxs.code.system.sysmenu.service.ISysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@OpenAPI30
@RestController
@RequestMapping("/system/sysmenu")
@Tag(name = "系统菜单表", description = "system模块-系统菜单表")
public class SysMenuController extends BaseController<SysMenu> {
    @Autowired
    ISysMenuService baseService;


    @Operation(summary = "查询所有菜单树", description = "查询菜单树")
    @GetMapping("getMenuTreeList")
    @AutoLog(title = "查询菜单树", type = LogConstant.LogType.SELECT, value = true)
    @HasPermissions(value = "sys:menu:list")
    public RspMsg<List<SysMenu>> getAllMenuList() throws Exception {
        return RspMsg.ok(baseService.getAllMenuList());
    }


    @Operation(summary = "未登录时候查询菜单树", description = "查询菜单树")
    @CrossOrigin
    @GetMapping("getMenuCommon")
    public RspMsg<List<SysMenu>> getAllMenuListWithoutToken() {
        return RspMsg.ok(baseService.getMenuCommon());
    }


}
