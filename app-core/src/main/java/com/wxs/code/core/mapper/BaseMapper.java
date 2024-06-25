/*
 *  @description: BaseMapper.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/20 下午2:17
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.mapper;

import com.wxs.code.core.entity.BaseEntity;

public interface BaseMapper<T extends BaseEntity> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
}
