/*
 *  @description: ISysMenuService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午10:51
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.entity.system.SysMenu;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getAllMenuList();

    List<SysMenu> getMenuCommon();
}
