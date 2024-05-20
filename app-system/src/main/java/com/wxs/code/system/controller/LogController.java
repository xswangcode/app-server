package com.wxs.code.system.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.core.entity.system.SysLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Tag(name = "日志", description = "系统模块-日志接口")
public class LogController extends BaseController<SysLog> {
}
