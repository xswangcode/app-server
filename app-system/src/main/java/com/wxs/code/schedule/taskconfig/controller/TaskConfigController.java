/*
 *  @description: TaskConfigController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:28
 *  @date: 2024-12-20 10:28
 *
 */

package com.wxs.code.schedule.taskconfig.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/schedule/taskconfig")
@Tag(name = "定时任务配置表", description = "schedule模块-定时任务配置表")
public class TaskConfigController extends BaseController<TaskConfig> {


}
