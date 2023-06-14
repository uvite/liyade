package com.ruoyi.project.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 密文管理对象 app_ciphertexts
 * 
 * @author ruoyi
 * @date 2023-05-20
 */
public class AppCiphertexts extends BaseEntity
{
    private static final long serialVersionUID = 1L;



    private AppProduct product;
    /** ID */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private String deviceId;

    /** 状态（0未烧写 */
    @Excel(name = "状态", readConverterExp = "状态（0未烧写")
    private String status;


    /** 产品类型 */
    @Excel(name = "产品类型")
    private Long productId;



    /** 密文内容 */
    @Excel(name = "密文内容")
    private String ciphertext;

    /** 密文路径 */
    @Excel(name = "密文路径")
    private String ciphertextPath;

    /** 密文md5 */
    @Excel(name = "密文md5")
    private String md5;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setCiphertext(String ciphertext) 
    {
        this.ciphertext = ciphertext;
    }

    public String getCiphertext() 
    {
        return ciphertext;
    }
    public void setCiphertextPath(String ciphertextPath) 
    {
        this.ciphertextPath = ciphertextPath;
    }

    public String getCiphertextPath() 
    {
        return ciphertextPath;
    }
    public void setMd5(String md5) 
    {
        this.md5 = md5;
    }

    public String getMd5() 
    {
        return md5;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public AppProduct getProduct() {
        return product;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("productId", getProductId())
            .append("status", getStatus())

            .append("ciphertext", getCiphertext())
            .append("ciphertextPath", getCiphertextPath())
            .append("md5", getMd5())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

}
