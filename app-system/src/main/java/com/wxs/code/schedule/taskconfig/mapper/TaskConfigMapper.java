/*
 *  @description: TaskConfigMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午4:25
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.schedule.taskconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxs.code.schedule.taskconfig.entity.TaskConfig;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TaskConfigMapper extends BaseMapper<TaskConfig> {

}
