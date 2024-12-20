/*
 *  @description: JobPool.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.beans;

import com.wxs.code.core.abstact.JobAbstract;
import org.dromara.hutool.core.map.MapUtil;

import java.util.Map;

public class JobPool {

    private static final Map<String, JobAbstract> JOB_POOL = MapUtil.newSafeConcurrentHashMap();

    public static JobAbstract getJob(String code) {
        return JOB_POOL.get(code);
    }

    public static void putJob(String code, JobAbstract job) {
        JOB_POOL.put(code, job);
    }
}
