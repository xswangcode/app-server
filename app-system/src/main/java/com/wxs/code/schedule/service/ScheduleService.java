/*
 *  @description: ScheduleService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:26
 *  @date: 2024-12-20 10:28
 *
 */

package com.wxs.code.schedule.service;


import com.wxs.code.schedule.taskconfig.service.ITaskConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleService {

    /**
     * 定时任务配置服务类
     */
    @Autowired
    ITaskConfigService tcSvc;


    // 启动服务【单】

    // 停止服务【单】

    // 重启服务【单】


    // 启动服务【全】

    // 停止服务【全】

    // 重启服务【全】

    // 执行一次job


}
