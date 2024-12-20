/*
 *  @description: TaskConfigController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.taskconfig.controller;

import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.schedule.service.ScheduleService;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@OpenAPI30
@RestController
@RequestMapping("/schedule/taskconfig")
@Tag(name = "定时任务配置表", description = "schedule模块-定时任务配置表")
public class TaskConfigController extends CoreController<TaskConfig> {
    @Autowired
    ScheduleService scheduleService;

    @Override
    @Deprecated
    @Transactional(rollbackFor = Exception.class)
    protected RspMsg<String> deleteBatch(String ids) {
        return RspMsg.deprecated();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected RspMsg<String> delete(String id) {
        TaskConfig byId = baseService.getById(id);
        scheduleService.stop(byId);
        return super.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected RspMsg<String> edit(TaskConfig dto, HttpServletRequest req) {
        TaskConfig old = baseService.getById(dto.getId());
        scheduleService.stop(old);
        super.edit(dto, req);
        dto = baseService.getById(dto.getId());
        scheduleService.start(dto);
        return RspMsg.OK("修改成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected RspMsg<String> add(TaskConfig dto, HttpServletRequest req) {
        super.add(dto, req);
        dto = baseService.getById(dto.getId());
        scheduleService.start(dto);
        return RspMsg.OK("新增成功!");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Deprecated
    protected RspMsg<String> addBatch(@RequestBody List<TaskConfig> dto, HttpServletRequest req) {
        return RspMsg.deprecated();
    }

}
