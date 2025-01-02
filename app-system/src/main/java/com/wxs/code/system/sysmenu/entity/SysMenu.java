/*
 *  @description: SysMenu.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.sysmenu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@TableName("sys_menu")
@Schema(description = "系统菜单表")
public class SysMenu extends BaseEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "name", description = "展示的名")
    private String name;

    @Schema(name = "path", description = "前端的href")
    private String path;

    @Schema(name = "title", description = "")
    private String title;

    @Schema(name = "redirect", description = "重定向URL")
    private String redirect;

    @Schema(name = "icon", description = "")
    private String icon;

    @Schema(name = "orderIdx", description = "排序字段")
    private Integer orderIdx;

    @Schema(name = "componentUrl", description = "子组件地址")
    private String componentUrl;

    @Schema(name = "common", description = "是否无token可用")
    private Boolean common;

    @Schema(name = "visible", description = "是否可见")
    private Boolean visible;

    @Schema(name = "parentId", description = "")
    private Long parentId;

}
