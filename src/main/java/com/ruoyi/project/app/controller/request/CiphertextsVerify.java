package com.ruoyi.project.app.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 密文管理对象 app_ciphertexts
 * 
 * @author ruoyi
 * @date 2023-05-20
 */
public class CiphertextsVerify
{
    private static final long serialVersionUID = 1L;


    /** 设备id */
    @Excel(name = "设备id")
    @JsonProperty("device_id")
    private String deviceId;

    /** 产品类型 */
    @Excel(name = "产品类型")
    @JsonProperty("product_type")
    private String productType;


    /** 密文内容 */
    @Excel(name = "密文内容")
    private List<Integer> ciphertext;


    public List<Integer> getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(List<Integer> ciphertext) {
        this.ciphertext = ciphertext;
    }


    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)

            .append("deviceId", getDeviceId())

            .append("productType", getProductType())

            .append("ciphertext", getCiphertext())

            .toString();
    }
}
