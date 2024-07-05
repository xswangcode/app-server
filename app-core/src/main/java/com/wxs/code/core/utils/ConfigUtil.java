/*
 *  @description: ConfigUtil.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/7/1 下午5:12
 *  @date: 2024-7-5 17:59
 *
 */

package com.wxs.code.core.utils;

import com.wxs.code.core.config.AppConfig;

public class ConfigUtil {
    public static AppConfig appConfig() {
        return SpringUtils.get(AppConfig.class);
    }
}
