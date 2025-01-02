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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@TableName("sys_user")
@Builder
@Schema(description = "系统用户表")
public class SysUser extends BaseEntity {


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

        @Schema(name = "createTime", description = "")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;

        @Schema(name = "updateTime", description = "")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updateTime;

        @Schema(name = "createById", description = "")
        private Long createById;

        @Schema(name = "updateById", description = "")
        private Long updateById;

        @Schema(name = "createBy", description = "")
        private String createBy;

        @Schema(name = "updateBy", description = "")
        private String updateBy;

}
