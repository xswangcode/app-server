/*
 *  @description: SysUser.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.sysuser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@Builder
@TableName("sys_user")
@Schema(description = "系统用户表")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends CoreEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "name", description = "")
    private String name;

    @Schema(name = "age", description = "")
    private Integer age;

    @Schema(name = "email", description = "")
    private String email;

    @Schema(name = "password", description = "加密后的密码")
    private String password;


}
