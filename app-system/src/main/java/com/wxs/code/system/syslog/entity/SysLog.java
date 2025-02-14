/*
 *  @description: SysLog.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:21
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.system.syslog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxs.code.core.constant.LogConstant;
import com.wxs.code.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@Builder
@TableName("sys_log")
@EqualsAndHashCode(callSuper = false)
@Schema(description = "系统日志表")
public class SysLog extends BaseEntity {


        @TableId(type = IdType.AUTO)
        @Schema(name = "id", description = "id")
        private Long id;

        @Schema(name = "clientIp", description = "客户端地址")
        private String clientIp;

        @Schema(name = "path", description = "接口地址")
        private String path;

        @Schema(name = "type", description = "日志类型")
        private LogConstant.LogType type;

        @Schema(name = "spendTime", description = "耗时")
        private Long spendTime;

        @Schema(name = "params", description = "参数")
        private String params;

        @Schema(name = "logLevel", description = "日志等级")
        private LogConstant.LogLeval logLevel;

        @Schema(name = "response", description = "返回信息")
        private String response;

        @Schema(name = "timespan", description = "创建时间")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime timespan;

        @Schema(name = "createBy", description = "创建人")
        private String createBy;

        @Schema(name = "createById", description = "创建人id")
        private Long createById;

}
