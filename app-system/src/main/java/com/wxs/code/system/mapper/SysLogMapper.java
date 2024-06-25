/*
 *  @description: SysLogMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午10:51
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.system.mapper;

import com.wxs.code.core.mapper.BaseMapper;
import com.wxs.code.entity.system.SysLog;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
