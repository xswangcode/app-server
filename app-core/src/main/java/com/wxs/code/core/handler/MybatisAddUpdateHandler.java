/*
 *  @description: MybatisAddUpdateHandler.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/4/2 下午2:13
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


/**
 * mybatis 更新和新建数据时候自动赋值
 *
 * @author wuxinsheng
 */
@Component
public class MybatisAddUpdateHandler implements MetaObjectHandler {

    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_TIME = "updateTime";
    private static final String CREATE_BY_ID = "createById";
    private static final String UPDATE_BY_ID = "updateById";
    private static final String CREATE_BY = "createBy";
    private static final String UPDATE_BY = "updateBy";


    @Override
    public void insertFill(MetaObject metaObject) {
        // 校验是否有创建时间字段
        if(metaObject.hasSetter(CREATE_TIME))
            metaObject.setValue(CREATE_TIME, System.currentTimeMillis());
        // 校验是否有更新时间字段
        if(metaObject.hasSetter(UPDATE_TIME))
            metaObject.setValue(UPDATE_TIME, System.currentTimeMillis());
        // 校验是否有创建人ID字段
        if(metaObject.hasSetter(CREATE_BY_ID))
            metaObject.setValue(CREATE_BY_ID, "1");
        // 校验是否有更新人ID字段
        if(metaObject.hasSetter(UPDATE_BY_ID))
            metaObject.setValue(UPDATE_BY_ID, "1");
        // 校验是否有创建人字段
        if(metaObject.hasSetter(CREATE_BY))
            metaObject.setValue(CREATE_BY, "admin");
        // 校验是否有更新人字段
        if(metaObject.hasSetter(UPDATE_BY))
            metaObject.setValue(UPDATE_BY, "admin");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 校验是否有更新时间字段
        if(metaObject.hasSetter(UPDATE_TIME))
            metaObject.setValue(UPDATE_TIME, System.currentTimeMillis());
        // 校验是否有更新人ID字段
        if(metaObject.hasSetter(UPDATE_BY_ID))
            metaObject.setValue(UPDATE_BY_ID, "1");
        // 校验是否有更新人字段
        if(metaObject.hasSetter(UPDATE_BY))
            metaObject.setValue(UPDATE_BY, "admin");
    }
}
