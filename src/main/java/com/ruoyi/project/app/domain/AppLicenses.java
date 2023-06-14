package com.ruoyi.project.app.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 授权管理对象 app_licenses
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
public class AppLicenses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** license */
    @Excel(name = "license")
    private String licenseId;

    /** 下载文件名称 */
    @Excel(name = "下载文件名称")
    private String fileName;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitStart;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date limitEnd;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    /** 项目名称 */
    @Excel(name = "项目地址")
    private String projectAddress;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String projectUsername;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String projectMobile;


    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    private String md5;

    public String getProjectSn() {
        return projectSn;
    }

    public void setProjectSn(String projectSn) {
        this.projectSn = projectSn;
    }

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectSn;

    /** 授权管理信息 */

    private List<AppDevicesStatus> devices;

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

    //@JsonGetter("devices")
    public List<AppDevicesStatus> getAppDevicesStatusList()
    {
        return devices;
    }

    public void setAppDevicesStatusList(List<AppDevicesStatus> appDevicesStatusList)
    {
        this.devices = appDevicesStatusList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("licenseId", getLicenseId())
            .append("fileName", getFileName())
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
            .append("devices", getAppDevicesStatusList())
            .toString();
    }
}
