package com.wxs.code.api.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.api.constant.ApiConstant;
import com.wxs.code.core.service.ApiBaseService;
import com.wxs.code.entity.biz.User;
import com.wxs.code.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.util.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class HelloTestApiService extends ApiBaseService {

    @Autowired
    IUserService userSvc;

    protected static Logger logger = LoggerFactory.getLogger(ApiBaseService.class);


    @Override
    public String getOutURL() {
        return ApiConstant.API_URL.HELLO_API_URL_TEST;
    }

    @Override
    public String getInnerURL() {
        return ApiConstant.API_URL.HELLO_API_URL_TEST;
    }


    @Override
    public Object process(Object obj) {
        Map map = (Map)obj;
        logger.info("hello {}", map.get("name"));
        List<User> list = userSvc.list(new Page<>(Integer.valueOf(map.get("page").toString()), Integer.valueOf(map.get("pageSize").toString())));
        logger.info("list {}", Arrays.toString(list.toArray()));
        return list;
    }
}
