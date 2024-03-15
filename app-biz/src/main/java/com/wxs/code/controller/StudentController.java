package com.wxs.code.controller;

import com.wxs.code.core.controller.BaseController;
import com.wxs.code.entity.Student;
import com.wxs.code.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
@Tag(name = "学生接口", description = "BIZ模块-学生接口")
@OpenAPI30
public class StudentController extends  BaseController<Student>{


}
