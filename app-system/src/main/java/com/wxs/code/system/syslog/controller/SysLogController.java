/*
 *  @description: SysLogController.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update:
 *  @date:
 */

package com.wxs.code.system.syslog.controller;

import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.syslog.entity.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/system/syslog")
@Tag(name = "系统日志表", description = "system模块-系统日志表")
public class SysLogController extends CoreController<SysLog> {




}
