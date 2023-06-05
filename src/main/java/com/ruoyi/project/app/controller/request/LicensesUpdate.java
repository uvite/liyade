package com.ruoyi.project.app.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 授权管理对象 app_licenses
 *
 * @author ruoyi
 * @date 2023-05-21
 */
public class LicensesUpdate {
    private static final long serialVersionUID = 1L;

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * license
     */
    @Excel(name = "license")
    private String licenseId;


    /**
     * 设备id
     */
    @Excel(name = "设备id")
    private List<String> deviceId;

    public List<String> getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(List<String> deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getUsed() {
        return used;
    }

    public void setUsed(List<String> used) {
        this.used = used;
    }

    /**
     * 是否使用（0未使用
     */
    @Excel(name = "是否使用", readConverterExp = "是否使用（0未使用")
    private List<String> used;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deviceId", getDeviceId())
                .toString();
    }
}
