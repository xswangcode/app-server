/*
 *  @description: TaskConfig.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.taskconfig.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@TableName("task_config")
@Schema(description = "定时任务配置表")
@EqualsAndHashCode(callSuper = true)
public class TaskConfig extends BaseEntity {


        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Integer id;

        @Schema(name = "code", description = "任务编码")
        private String code;

        @Schema(name = "name", description = "任务名称")
        private String name;

        @Schema(name = "job", description = "job类名")
        private String job;

        @Schema(name = "groupName", description = "组名")
        private String groupName;

        @Schema(name = "description", description = "任务描述")
        private String description;

        @Schema(name = "cronText", description = "定时表达式")
        private String cronText;

        @Schema(name = "params", description = "参数，值类型为json")
        private String params;

        @Schema(name = "status", description = "任务状态")
        private Boolean status;

        @Schema(name = "isDoNow", description = "是否立即执行")
        private Boolean isDoNow;

        @Schema(name = "isAllowConcurrent", description = "是否允许并发执行")
        private Boolean isAllowConcurrent;

        @Schema(name = "isWorking", description = "是否正在执行")
        private Boolean isWorking;

}
