package com.ruoyi.project.app.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 授权管理对象 app_licenses
 *
 * @author ruoyi
 * @date 2023-05-21
 */
public class LicensesGet
{
    private static final long serialVersionUID = 1L;




    /** 设备id */
    @Excel(name = "设备id")
    @JsonProperty("device_id")
    private List<String> deviceId;
    public List<String> getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(List<String> deviceId) {
        this.deviceId = deviceId;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)

                .append("deviceId", getDeviceId())


                .toString();
    }
}
