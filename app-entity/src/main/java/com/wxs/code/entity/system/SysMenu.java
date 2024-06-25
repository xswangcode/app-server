/*
 *  @description: SysMenu.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午9:48
 *  @date: 2024-6-25 10:51
 *
 */

package com.wxs.code.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.BaseEntity;
import lombok.Data;

import java.util.List;

@TableName("sys_menu")
@Data
public class SysMenu extends BaseEntity {

    @TableId
    Long id;
    String path;
    String name;
    String title;
    String redirect;
    String icon;
    Integer orderIdx;
    String componentUrl;
    Long parentId;

    Boolean common = false;
    Boolean visible = true;

    @TableField(exist = false)
    List<SysMenu> children;
}
