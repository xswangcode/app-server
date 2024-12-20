/*
 *  @description: ScheduleController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.controller;

import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.BaseController;
import com.wxs.code.core.exception.SystemException;
import com.wxs.code.schedule.service.ScheduleService;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import com.wxs.code.schedule.taskconfig.service.ITaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/schedule")
@RestController
public class ScheduleController extends BaseController {

    /**
     * 定时任务配置服务类
     */
    @Autowired
    ITaskConfigService tcSvc;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/start")
    public RspMsg start(@RequestParam String taskId) throws SystemException {
        TaskConfig taskConfig = tcSvc.getById(taskId);
        return RspMsg.response(scheduleService.start(taskConfig));
    }

    @GetMapping("/stop")
    public RspMsg stop(@RequestParam String taskId) throws SystemException {
        TaskConfig taskConfig = tcSvc.getById(taskId);
        return RspMsg.response(scheduleService.stop(taskConfig));
    }

    @GetMapping("/restart")
    public RspMsg restart(@RequestParam String taskId) throws SystemException {
        TaskConfig taskConfig = tcSvc.getById(taskId);
        return RspMsg.response(scheduleService.restart(taskConfig));
    }

    @GetMapping("/runOnce")
    public RspMsg runOnce(@RequestParam String taskId) throws SystemException {
        return RspMsg.response(scheduleService.runOnce(taskId));
    }
}
