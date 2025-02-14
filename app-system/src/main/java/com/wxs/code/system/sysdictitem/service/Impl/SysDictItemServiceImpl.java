/*
 *  @description: SysDictItemServiceImpl.java
 *
 *  @author:  xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2025-02-14 15:59:26
 *  @date: 2025-02-14 15:59:26
 *
 */



package com.wxs.code.system.sysdictitem.service.Impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxs.code.core.service.BaseService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wxs.code.system.sysdictitem.service.ISysDictItemService;
import com.wxs.code.system.sysdictitem.entity.SysDictItem;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Service
public class SysDictItemServiceImpl extends BaseService<SysDictItem> implements ISysDictItemService {


}
