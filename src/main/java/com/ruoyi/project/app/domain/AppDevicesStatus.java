package com.ruoyi.project.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 授权管理对象 app_devices_status
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
public class AppDevicesStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;


    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    /** license id */
    @Excel(name = "licenseid")
    private Long licenseId;

    /** 设备id */
    @Excel(name = "设备id")
    private String deviceId;

    /** 是否使用（0未使用 */
    @Excel(name = "是否使用", readConverterExp = "是否使用（0未使用")
    private String used;

    /** 状态（0未审核 */
    @Excel(name = "状态", readConverterExp = "状态（0未审核")
    private String enabled;

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
    public void setUsed(String used) 
    {
        this.used = used;
    }

    public String getUsed() 
    {
        return used;
    }
    public void setEnabled(String enabled) 
    {
        this.enabled = enabled;
    }

    public String getEnabled() 
    {
        return enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("licenseId", getLicenseId())
            .append("used", getUsed())
            .append("enabled", getEnabled())
            .toString();
    }
}
