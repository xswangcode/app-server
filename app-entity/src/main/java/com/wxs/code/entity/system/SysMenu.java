package com.wxs.code.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.BaseEntity;

@TableName("sys_menu")
public class SysMenu extends BaseEntity {

    @TableId
    Long id;

    String name;
    String title;
    String icon;
    Integer orderIdx;
    String componentUrl;
    Long parentId;
}
