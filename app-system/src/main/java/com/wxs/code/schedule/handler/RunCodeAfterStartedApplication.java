/*
 *  @description: RunCodeAfterStartedApplication.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxs.code.schedule.service.ScheduleService;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import com.wxs.code.schedule.taskconfig.service.ITaskConfigService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * springboot 启动完成后自启动定时任务
 *
 * @author: xswang
 */
@Component
@Slf4j
public class RunCodeAfterStartedApplication implements CommandLineRunner {


    /**
     * 定时任务配置服务类
     */
    @Autowired
    ITaskConfigService tcSvc;
    @Autowired
    Scheduler scheduler;
    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void run(String... args) {
        try {
            List<TaskConfig> tasks = tcSvc.list(Wrappers.lambdaQuery(TaskConfig.class).eq(TaskConfig::getStatus, true));
            tasks.forEach(scheduleService::start);
            scheduler.start();
            log.info("启动定时任务调度器成功！");
        } catch (SchedulerException e) {
            log.error("初始化启动定时任务调度器失败！{}", e);
        }
    }
}
