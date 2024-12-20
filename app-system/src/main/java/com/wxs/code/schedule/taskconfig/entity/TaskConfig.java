/*
 *  @description: TaskConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:28
 *  @date: 2024-12-20 10:28
 *
 */

package com.wxs.code.schedule.taskconfig.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@TableName("task_config")
@Schema(description = "定时任务配置表")
@EqualsAndHashCode(callSuper = true)
public class TaskConfig extends BaseEntity {


    @TableId(type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    private Integer id;

    @Schema(name = "name", description = "姓名")
    private String name;

    @Schema(name = "age", description = "年龄")
    private Integer age;

    @Schema(name = "email", description = "邮箱")
    private String email;

    @Schema(name = "userPassword", description = "明文密码")
    private String userPassword;

    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(name = "ts", description = "创建时间2")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ts;

}
