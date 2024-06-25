/*
 *  @description: LogConstant.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/5/20 下午5:08
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.constant;

public class LogConstant {


    /**
     * 日志类型
     * 增 删 改 查，定时任务，接口日志，异常日志， 登录日志， 操作日志
     */
    public enum LogType {

        /**
         * 新增
         */
        INSERT,
        /**
         * 删除
         */
        DELETE,
        /**
         * 修改
         */
        UPDATE,
        /**
         * 查询
         */
        SELECT,

        /**
         * 定时任务
         */
        TIMER,
        /**
         * 接口日志
         */
        API,
        /**
         * 异常日志
         */
        EXCEPTION,

        /**
         * 登录日志
         */
        LOGIN,
        /**
         * 操作日志
         */
        OPERATION

    }

    /**
     * 日志等级
     */
    public enum LogLeval {

        /**
         * 默认
         */
        DEFAULT,

        /**
         * 调试
         */
        DEBUG,
        /**
         * 信息
         */
        INFO,
        /**
         * 警告
         */
        WARN,
        /**
         * 错误
         */
        ERROR
    }


}
