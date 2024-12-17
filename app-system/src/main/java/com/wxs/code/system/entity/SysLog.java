/*
 *  @description: SysLog.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wxs.code.core.constant.LogConstant;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Getter
@Setter
@Schema(description = "用户日志")
@Builder
@TableName("sys_log")
public class SysLog extends BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(name = "id", description = "id")
    Long id;

    @Schema(name = "客户端IP", description = "客户端IP")
    String clientIp;
    @Schema(name = "操作描述", description = "操作描述")
    String title;
    @Schema(name = "业务id", description = "业务id")
    String bizId;
    @Schema(name = "操作类型", description = "操作类型")
    LogConstant.LogType type;
    @Schema(name = "操作耗时", description = "操作耗时")
    Long spendTime;
    @Schema(name = "日志等级", description = "日志等级")
    LogConstant.LogLeval logLevel;
    @Schema(name = "操作时间", description = "操作时间")
    LocalDateTime timespan;
    @Schema(name = "入参", description = "入参")
    String params;
    @Schema(name = "返回值", description = "返回值")
    String response;
    @Schema(name = "操作人", description = "操作人")
    String createBy;
    @Schema(name = "操作人Id", description = "操作人Id")
    Long createById;
}
