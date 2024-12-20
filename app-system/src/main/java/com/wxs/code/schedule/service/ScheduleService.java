/*
 *  @description: ScheduleService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.service;

import com.wxs.code.core.abstact.JobAbstract;
import com.wxs.code.core.exception.SystemException;
import com.wxs.code.core.utils.SpringUtils;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import com.wxs.code.schedule.taskconfig.service.ITaskConfigService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ScheduleService {

    /**
     * 定时任务配置服务类
     */
    @Autowired
    ITaskConfigService tcSvc;

    static String Job_Params_Key = "params";
    @Autowired
    Scheduler scheduler;

    // 启动服务【单】
    public Boolean start(TaskConfig taskConfig) throws SystemException {
        log.info("启动服务【单】");
        if (taskConfig == null)
            throw new SystemException("不存在ID为【" + taskConfig.getId() + "】的任务！");

        // 构建定时任务
        JobAbstract job = SpringUtils.getByFullname(taskConfig.getJob());

        if (job == null) {
            throw new SystemException("未找到对应的任务！");
        }
        // 任务参数
        JobDetail jobDetail = createJobDetail(job, taskConfig);
        // 触发器
        TriggerBuilder<CronTrigger> triggerBuilder = TriggerBuilder.newTrigger()
                .withIdentity(taskConfig.getName() + "_Trigger", taskConfig.getName() + "_" + taskConfig.getGroupName())
                .withSchedule(CronScheduleBuilder.cronSchedule(taskConfig.getCronText()))
                .forJob(jobDetail.getKey());

        if (taskConfig.getIsDoNow()) {
            triggerBuilder.startNow();
        }
        CronTrigger trigger = triggerBuilder.build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error("启动定时任务失败！{}", e);
            throw new SystemException("启动定时任务失败！");
        }
        return true;
    }


    // 停止服务【单】

    public Boolean stop(TaskConfig taskConfig) throws SystemException {
        log.info("停止服务【单】");

//        TaskConfig taskConfig = tcSvc.getById(taskId);
        if (taskConfig == null)
            throw new SystemException("不存在ID为【" + taskConfig.getId() + "】的任务！");
        // 构建定时任务
        JobAbstract job = SpringUtils.getByFullname(taskConfig.getJob());

        if (job == null) {
            throw new SystemException("未找到对应的任务！");
        }

        try {
            scheduler.deleteJob(JobKey.jobKey(taskConfig.getName(), taskConfig.getGroupName()));
        } catch (SchedulerException e) {
            log.error("关闭定时任务失败！{}", e);
            throw new SystemException("启动定时任务失败！");
        }
        return true;
    }

    // 重启服务【单】
    public Boolean restart(TaskConfig taskConfig) throws SystemException {
        log.info("重启服务【单】");
        boolean b = stop(taskConfig);
        if (!b) {
            return b;
        }
        b = start(taskConfig);
        if (!b) {
            return b;
        }
        return true;
    }

    // 启动服务【全】

    // 停止服务【全】

    // 重启服务【全】

    // 执行一次job
    public Boolean runOnce(String taskId) throws SystemException {
        log.info("执行一次job");
        TaskConfig taskConfig = tcSvc.getById(taskId);
        if (taskConfig == null)
            throw new SystemException("不存在ID为【" + taskId + "】的任务！");
        // 构建定时任务
        JobAbstract job = SpringUtils.getByFullname(taskConfig.getJob());

        if (job == null) {
            throw new SystemException("未找到对应的任务！");
        }
        // 构建参数
        JobDetail jobDetail = createJobDetail(job, taskConfig);
        // 触发器
        Date runTime = new Date(System.currentTimeMillis() + 500); // 0.5秒后执行
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(taskConfig.getName() + "_Trigger", taskConfig.getName() + "_" + taskConfig.getGroupName())
                .forJob(jobDetail.getKey())
                .startAt(runTime).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error("启动定时任务失败！{}", e);
            throw new SystemException("启动定时任务失败！");
        }
        return true;
    }


    private JobDetail createJobDetail(JobAbstract job, TaskConfig taskConfig) {
        JobKey jobKey = JobKey.jobKey(taskConfig.getName(), taskConfig.getGroupName());
        try {
            if (scheduler.checkExists(jobKey)) {
                return scheduler.getJobDetail(jobKey);
            }
        } catch (SchedulerException e) {
            throw new SystemException("获取已存在的定时任务失败！");
        }
        // 构建参数
        return JobBuilder.newJob(job.getClass())
                .withIdentity(taskConfig.getName(), taskConfig.getGroupName())
                .usingJobData(Job_Params_Key, taskConfig.getParams())
                .build();
    }


}
