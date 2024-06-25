/*
 *  @description: CodeGenerateController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 下午5:57
 *  @date: 2024-6-25 18:2
 *
 */

package com.wxs.code.generate.controller;


import com.jfinal.template.ext.spring.JFinalViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code/generate")
public class CodeGenerateController {

    @Autowired
    JFinalViewResolver jFinalViewResolver;

}
