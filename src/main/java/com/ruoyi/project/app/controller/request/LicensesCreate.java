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
public class LicensesCreate
{
    private static final long serialVersionUID = 1L;




    /** 设备id */
    @Excel(name = "设备id")
    private List<String> deviceId;
    public List<String> getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(List<String> deviceId) {
        this.deviceId = deviceId;
    }


    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitStart;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitEnd;



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private Project project;


    public void setLimitStart(Date limitStart)
    {
        this.limitStart = limitStart;
    }

    public Date getLimitStart()
    {
        return limitStart;
    }
    public void setLimitEnd(Date limitEnd)
    {
        this.limitEnd = limitEnd;
    }

    public Date getLimitEnd()
    {
        return limitEnd;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)

                .append("deviceId", getDeviceId())

                .append("limitStart", getLimitStart())
                .append("limitEnd", getLimitEnd())
                .append("project", getProject())
                .toString();
    }
}
