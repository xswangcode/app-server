/*
 *  @description: SystemException.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/12/20 下午5:24
 *  @date: 2024-12-20 17:24
 *
 */

package com.wxs.code.core.exception;

public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SystemException(String error) {
        super(error);
    }

    public SystemException(Exception e) {
        super(e);
    }

}
