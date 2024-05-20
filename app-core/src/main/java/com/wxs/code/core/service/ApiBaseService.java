package com.wxs.code.core.service;

import jakarta.annotation.PostConstruct;

import java.util.LinkedHashMap;

public abstract class ApiBaseService {
    private static final LinkedHashMap<String,ApiBaseService> SERVICE_POOL = new LinkedHashMap();


    /**
     * 初始化方法
     */
    @PostConstruct
    public void init(){
        SERVICE_POOL.put(getInnerURL(),this);
    }


    /**
     * 其他开放平台的URL地址
     */
    public abstract String getOutURL();

    /**
     * 本地App服务的地址
     */
    public abstract String getInnerURL();


    /**
     * 接受到数据先进行数据预处理，有需要可以重写该方法
     * @param obj
     * @return
     */
    public Object parseData(Object obj){
        return obj;
    }

    /**
     * 接收预处理之后的数据，执行业务逻辑
     * @param obj
     * @return
     */
    public abstract Object process(Object obj);

    /**
     * 执行完业务处理之后的逻辑
     * @param obj
     * @return
     */
    public Object processed(Object obj){
        return obj;
    }



    public static ApiBaseService getServiceByApi(String api){
        return SERVICE_POOL.get(api);
    }
}
