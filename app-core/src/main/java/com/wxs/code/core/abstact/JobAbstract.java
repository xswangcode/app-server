/*
 *  @description: JobAbstract.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.abstact;

import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.json.JSONUtil;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Map;


@Slf4j
public abstract class JobAbstract implements Job {

    /**
     * 解析参数
     *
     * @return
     */
    Map<String, Object> parseParams(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String str_params = dataMap.getString("params") == null ? "" : dataMap.getString("params");
        try {
            Map<String, Object> map = JSONUtil.toBean(str_params, Map.class);
            return map;
        } catch (Exception e) {
            log.error(getClass() + " parseParams error:{} ", str_params, e);
        }
        /**
         * 返回的一定是一个Map, 如果不能解析成Map，构建一个具有 params参数的Map返回
         */
        return Map.of("params", str_params);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Map<String, Object> params = parseParams(context);
            process(params);
        } catch (Exception e) {
            log.error(getClass() + " execute error: {} ", e);
        }
    }

    public abstract void process(Map<String, Object> params);

}
