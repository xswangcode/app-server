package com.wxs.code.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.entity.system.SysMenu;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getAllMenuList();

    List<SysMenu> getMenuCommon();
}
