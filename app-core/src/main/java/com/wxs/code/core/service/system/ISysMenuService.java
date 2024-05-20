package com.wxs.code.core.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.entity.system.SysMenu;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getAllMenuList();

    List<SysMenu> getMenuCommon();
}
