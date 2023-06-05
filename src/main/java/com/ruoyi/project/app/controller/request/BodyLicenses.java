package com.ruoyi.project.app.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
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
public class BodyLicenses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** license */
    @Excel(name = "license")
    @JsonProperty("license_id")
    private String licenseId;

    /** 下载文件名称 */
    @Excel(name = "下载文件名称")
    private String fileName;

    public List<String> getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(List<String> deviceId) {
        this.deviceId = deviceId;
    }

    /** 设备id */
    @Excel(name = "设备id")
    @JsonProperty("device_id")
    private List<String> deviceId;

    /** 是否使用（0未使用 */
    @Excel(name = "是否使用", readConverterExp = "是否使用（0未使用")
    private List<String> used;

    /** 状态（0未审核 */
    @Excel(name = "状态", readConverterExp = "状态（0未审核")
    private String enabled;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonProperty("limit_start")
    private Date limitStart;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonProperty("limit_end")
    private Date limitEnd;



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private Project project;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLicenseId(String licenseId)
    {
        this.licenseId = licenseId;
    }

    public String getLicenseId()
    {
        return licenseId;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setUsed(List<String> used)
    {
        this.used = used;
    }

    public List<String> getUsed()
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
