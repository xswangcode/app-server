package com.wxs.code.api.service;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.api.constant.ApiConstant;
import com.wxs.code.core.service.ApiBaseService;
import com.wxs.code.entity.biz.User;
import com.wxs.code.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.util.MapUtil;
import org.dromara.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class HelloTestApiService extends ApiBaseService {

    final IUserService userSvc;
    public HelloTestApiService(IUserService userSvc) {
        this.userSvc = userSvc;
    }
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
        Map map = BeanUtil.copyProperties(obj,Map.class);
        logger.debug("hello {}", map.get("name"));
        int page =  Integer.parseInt(String.valueOf(map.get("page")));
        int pageSize =   Integer.parseInt(String.valueOf(map.get("pageSize")));
        Page<User> pageArg = new Page<>(page, pageSize);
        pageArg= userSvc.page(pageArg);
        logger.debug("pageArg {}", Arrays.toString(pageArg.getRecords().toArray()));
        return pageArg;
    }
}
