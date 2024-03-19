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
