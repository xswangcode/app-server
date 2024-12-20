/*
 *  @description: TestJob.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.test;

import com.wxs.code.core.abstact.JobAbstract;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class TestJob extends JobAbstract {

    @Override
    public void process(Map<String, Object> params) {
        System.out.println("Job says: " + params.get("a"));
    }
}
