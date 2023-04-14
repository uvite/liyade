package com.ruoyi.project.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 秘钥对象 app_private
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public class AppPrivate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long privateId;

    /** 公钥 */
    @Excel(name = "公钥")
    private String publicKey;

    /** 私钥 */
    @Excel(name = "私钥")
    private String privateKey;

    /** 加密类型 */
    @Excel(name = "加密类型")
    private String privateType;

    /** 有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validDate;

    public void setPrivateId(Long privateId) 
    {
        this.privateId = privateId;
    }

    public Long getPrivateId() 
    {
        return privateId;
    }
    public void setPublicKey(String publicKey) 
    {
        this.publicKey = publicKey;
    }

    public String getPublicKey() 
    {
        return publicKey;
    }
    public void setPrivateKey(String privateKey) 
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() 
    {
        return privateKey;
    }
    public void setPrivateType(String privateType) 
    {
        this.privateType = privateType;
    }

    public String getPrivateType() 
    {
        return privateType;
    }
    public void setValidDate(Date validDate) 
    {
        this.validDate = validDate;
    }

    public Date getValidDate() 
    {
        return validDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("privateId", getPrivateId())
            .append("publicKey", getPublicKey())
            .append("privateKey", getPrivateKey())
            .append("privateType", getPrivateType())
            .append("validDate", getValidDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
