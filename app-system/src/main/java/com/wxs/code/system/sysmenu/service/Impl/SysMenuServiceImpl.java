/*
 *  @description: SysMenuServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */


package com.wxs.code.system.sysmenu.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.sysmenu.entity.SysMenu;
import com.wxs.code.system.sysmenu.service.ISysMenuService;
import org.dromara.hutool.core.util.ObjUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends BaseService<SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getAllMenuList() {
        List<SysMenu> list = list();
        // 查询所有一级菜单
        return getMenuListByParentId(list, null);
    }

    @Override
    public List<SysMenu> getMenuCommon() {
        List<SysMenu> list = list(Wrappers.lambdaQuery(SysMenu.class).eq(SysMenu::getCommon, true));
        // 查询所有一级菜单
        return getMenuListByParentId(list, null);
    }

    private List<SysMenu> getMenuListByParentId(List<SysMenu> allList, Long parentId) {
        List<SysMenu> result = Collections.emptyList();
//        List<SysMenu> list = allList.stream().filter(el -> Objects.equals(el.getParentId(), parentId)).sorted(Comparator.comparingInt(SysMenu::getOrderIdx)).collect(Collectors.toList());
//        // 方式1 ： 使用过递归，每个menu都需要查一次子项，效率低
//        list.forEach(el -> {
//            List<SysMenu> children = getMenuListByParentId(allList, el.getId());
//            children.sort(Comparator.comparingInt(SysMenu::getOrderIdx));
//            System.out.println("parentId"+el.getId()+"  children = " + children);
//            el.setChildren(children);
//        });

        // 方式2： 使用分组，快速
        Map<Long, List<SysMenu>> collect = allList.stream().filter(el -> ObjUtil.isNotEmpty(el.getParentId())).collect(Collectors.groupingBy(SysMenu::getParentId));
        allList.forEach(el -> {
            if (collect.get(el.getId()) != null) {
                el.setChildren(collect.get(el.getId()).stream().sorted(Comparator.comparingLong(SysMenu::getOrderIdx)).toList());
            }
        });

        result = allList.stream().filter(el -> Objects.equals(el.getParentId(), parentId)).sorted(Comparator.comparingInt(SysMenu::getOrderIdx)).collect(Collectors.toList());

        return result;
    }
}
