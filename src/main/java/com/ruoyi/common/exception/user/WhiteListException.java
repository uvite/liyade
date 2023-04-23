package com.ruoyi.common.exception.user;

/**
 * 白名单IP异常类
 * 
 * @author ruoyi
 */
public class WhiteListException extends UserException
{
    private static final long serialVersionUID = 1L;

    public WhiteListException()
    {
        super("login.whiteip", null);
    }
}
