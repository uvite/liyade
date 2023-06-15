package com.ruoyi.common.exception.base;

import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.StringUtils;

/**
 * 基础异常
 * 
 * @author ruoyi
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误编码
     */
    private Integer msgCode;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage, Integer msgCode)
    {
        this.module = module;
        this.code = code;
        this.msgCode = msgCode;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args,Integer msgCode)
    {
        this(module, code, args, null,msgCode);
    }

    public BaseException(String module, String defaultMessage,Integer msgCode)
    {
        this(module, null, null, defaultMessage,msgCode);
    }

    public BaseException(String code, Object[] args,Integer msgCode)
    {
        this(null, code, args, null,msgCode);
    }

    public BaseException(String defaultMessage,Integer msgCode)
    {
        this(null, null, null, defaultMessage,msgCode);
    }

    @Override
    public String getMessage()
    {
        String message = null;
        if (!StringUtils.isEmpty(code))
        {
            message = MessageUtils.message(code, args);
        }
        if (message == null)
        {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule()
    {
        return module;
    }

    public String getCode()
    {
        return code;
    }

    public Integer getMsgCode()
    {
        return msgCode;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getDefaultMessage()
    {
        return defaultMessage;
    }
}
