/*
 *  @description: ISysMenuService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:39
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysmenu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.system.sysmenu.entity.SysMenu;

import java.util.List;


public interface ISysMenuService extends IService<SysMenu> {
    List<SysMenu> getAllMenuList();

    List<SysMenu> getMenuCommon();
}