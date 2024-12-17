/*
 *  @description: SysLogMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/16 下午3:27
 *  @date: 2024-12-17 15:26
 *
 */

package com.wxs.code.system.mapper;

import com.wxs.code.core.mapper.BaseMapper;
import com.wxs.code.system.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
