/*
 *  @description: SysLogServiceImpl.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 上午10:40
 *  @date: 2024-12-20 17:24
 *
 */



package com.wxs.code.system.syslog.service.Impl;


import com.wxs.code.core.service.BaseService;
import com.wxs.code.system.syslog.entity.SysLog;
import com.wxs.code.system.syslog.mapper.SysLogMapper;
import com.wxs.code.system.syslog.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends BaseService<SysLog, SysLogMapper> implements ISysLogService {

}
