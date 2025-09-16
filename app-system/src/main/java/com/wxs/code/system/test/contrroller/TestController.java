package com.wxs.code.system.test.contrroller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.constant.CoreConstants;
import com.wxs.code.core.constant.SystemConstants;
import com.wxs.code.core.controller.CoreController;
import com.wxs.code.system.sysrole.entity.SysRole;
import com.wxs.code.system.sysrole.mapper.SysRoleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.hutool.core.text.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@OpenAPI30
@RestController
@RequestMapping("test")
@Tag(name = "测试类", description = "system模块-测试类")
public class TestController {

    /**
     * 查询接口
     *
     * @return
     */
    @RequestMapping("test1")
    @Operation(summary = "获取当前时间")
    public RspMsg<LocalDateTime> list() {
        Object o = StpUtil.getStpLogic().getSession().get(CoreConstants.USER_EXTRA_USERNAME);
        return RspMsg.ok(StrUtil.format("hello "+o + " ,当前时间："+LocalDateTime.now()));
    }
}
