/*
 *  @description: AuthExecption.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/3/19 上午10:53
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.exception;

public class AuthExecption extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public AuthExecption(String message)
    {
        super(message);
    }

    public AuthExecption(String message, Throwable cause)
    {
        super(message, cause);
    }
}
