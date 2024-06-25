/*
 *  @description: HelloTestApiService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 上午10:51
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxs.code.api.constant.ApiConstant;
import com.wxs.code.core.service.ApiBaseService;
import com.wxs.code.entity.system.SysUser;
import com.wxs.code.system.service.ISysUserService;
import org.dromara.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;


@Service
public class HelloTestApiService extends ApiBaseService {

    final ISysUserService userSvc;
    public HelloTestApiService(ISysUserService userSvc) {
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
        Page<SysUser> pageArg = new Page<>(page, pageSize);
        pageArg= userSvc.page(pageArg);
        logger.debug("pageArg {}", Arrays.toString(pageArg.getRecords().toArray()));
        return pageArg;
    }
}
