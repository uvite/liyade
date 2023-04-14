package com.ruoyi.project.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 参数配置对象 app_device
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public class AppDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private Long deviceId;

    /** 名称 */
    @Excel(name = "名称")
    private String deviceName;

    /** 类型 */
    @Excel(name = "类型")
    private String deviceType;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long supplierId;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String deviceStatus;

    /** 编号 */
    @Excel(name = "编号")
    private String deviceCode;

    private AppSupplier supplier;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setDeviceStatus(String deviceStatus) 
    {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceStatus() 
    {
        return deviceStatus;
    }
    public void setDeviceCode(String deviceCode) 
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode() 
    {
        return deviceCode;
    }

    public AppSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(AppSupplier supplier) {
        this.supplier = supplier;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("deviceType", getDeviceType())
            .append("supplierId", getSupplierId())
            .append("deviceStatus", getDeviceStatus())
            .append("deviceCode", getDeviceCode())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("supplier", getSupplier())
            .toString();
    }


}
