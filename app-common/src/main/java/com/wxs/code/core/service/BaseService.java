package com.wxs.code.core.service;

import com.wxs.code.core.entity.BaseEntity;
import com.wxs.code.core.mapper.BaseMapper;

public class BaseService<T extends BaseEntity> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<BaseMapper<T>, T>{

}
