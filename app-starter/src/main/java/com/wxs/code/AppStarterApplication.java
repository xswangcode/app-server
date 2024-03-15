package com.wxs.code;

import com.wxs.code.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppStarterApplication  {

    public static void main(String[] args) {
        ApplicationContext ctx=  SpringApplication.run(AppStarterApplication.class, args);
        System.out.println("UserMapper: "+ ctx.getBean(UserMapper.class));
    }

}
