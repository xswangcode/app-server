package com.wxs.code.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.wxs.code.core.api.VO.RspMsg;
import com.wxs.code.core.controller.BaseController;
import com.wxs.code.entity.biz.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@Tag(name = "用户接口", description = "BIZ模块-用户接口")
public class UserController extends BaseController<User> {


}
