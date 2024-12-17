/*
 *  @description: StudentController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/17 下午3:26
 *  @date: 2024-12-17 15:26
 *
 */

/*
 *  @description: StudentController.java
 *
 *  @author:  xswang
 *  @email: xswang.code@126.com
 *  @version: 1.0.0
 *  @last update: 2024-12-17 15:24:34
 *  @date: 2024-12-17 15:24:34
 */

package com.wxs.code.biz.student.controller;

import com.wxs.code.biz.student.entity.Student;
import com.wxs.code.core.controller.BaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@OpenAPI30
@RestController
@RequestMapping("/biz/student")
@Tag(name = "学生信息表", description = "biz模块-学生信息表")
public class StudentController extends  BaseController<Student>{


}
