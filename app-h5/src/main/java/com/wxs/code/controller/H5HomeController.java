package com.wxs.code.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("h5Home")
@Schema(name = "H5",description = "H5")
public class H5HomeController {

    @GetMapping("H5index")
    @Operation(summary = "H5首页",description = "首页",tags = {"首页"})
    String h5index(){
        return LocalDateTime.now().toString();
    }
}
