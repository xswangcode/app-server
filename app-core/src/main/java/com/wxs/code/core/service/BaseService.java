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

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxs.code.core.entity.BaseEntity;

public class BaseService<T extends BaseEntity, M extends BaseMapper<T>> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> {

}
