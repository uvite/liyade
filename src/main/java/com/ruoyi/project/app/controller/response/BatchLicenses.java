package com.ruoyi.project.app.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BatchLicenses extends BaseEntity
{
    private static final long serialVersionUID = 1L;




    /** license */
    @Excel(name = "license")
    private String licenseId;

    /** 下载文件名称 */
    @Excel(name = "下载文件名称")
    private String fileName;

    /** 设备id */
    @Excel(name = "设备id")
    private List<String> deviceId;


    /** 是否使用（0未使用 */
    @Excel(name = "是否使用", readConverterExp = "是否使用（0未使用")
    private List<String> used;


    /** 状态（0未审核 */
    @Excel(name = "状态", readConverterExp = "状态（0未审核")
    private List<String> enabled;


    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitStart;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitEnd;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String projectUsername;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String projectMobile;


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

    public List<String> getEnabled() {
        return enabled;
    }

    public void setEnabled(List<String> enabled) {
        this.enabled = enabled;
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
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectUsername(String projectUsername)
    {
        this.projectUsername = projectUsername;
    }

    public String getProjectUsername()
    {
        return projectUsername;
    }
    public void setProjectMobile(String projectMobile)
    {
        this.projectMobile = projectMobile;
    }

    public String getProjectMobile()
    {
        return projectMobile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)

                .append("licenseId", getLicenseId())
                .append("fileName", getFileName())
                .append("deviceId", getDeviceId())
                .append("used", getUsed())
                .append("enabled", getEnabled())
                .append("limitStart", getLimitStart())
                .append("limitEnd", getLimitEnd())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("projectName", getProjectName())
                .append("projectUsername", getProjectUsername())
                .append("projectMobile", getProjectMobile())
                .toString();
    }
}
