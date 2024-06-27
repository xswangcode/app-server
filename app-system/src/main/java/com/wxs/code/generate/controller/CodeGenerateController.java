/*
 *  @description: CodeGenerateController.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/27 上午11:40
 *  @date: 2024-6-27 11:40
 *
 */

package com.wxs.code.generate.controller;


import com.wxs.code.core.ext.spring.JFinalViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code/generate")
public class CodeGenerateController {

    @Autowired
    JFinalViewResolver jFinalViewResolver;

}
