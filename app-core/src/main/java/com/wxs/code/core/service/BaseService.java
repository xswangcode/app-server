/*
 *  @description: BaseService.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/14 下午4:53
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.service;

import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.mapper.BaseMapper;

public class BaseService<T extends BaseEntity> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<BaseMapper<T>, T>{

}
