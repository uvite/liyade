package com.ruoyi.project.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备管理对象 app_device
 * 
 * @author ruoyi
 * @date 2023-04-22
 */
public class AppDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private AppSupplier supplier;
    private AppProduct product;

    /** 设备ID */
    private Long deviceId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private Long productId;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long supplierId;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String deviceStatus;

    /** 编号 */
    @Excel(name = "编号")
    private String deviceCode;

    /** 入库人 */
    @Excel(name = "入库人")
    private String deviceInStockBy;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deviceInStockTime;

    /** 出库人 */
    @Excel(name = "出库人")
    private String deviceOutStockBy;

    /** 出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deviceOutStockTime;

    /** 状态（0入库 */
    @Excel(name = "状态", readConverterExp = "状态（0入库")
    private String stockStatus;

    /** 删除者 */
    @Excel(name = "删除者")
    private String deleteBy;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    /** 逻辑删除标识位
 */
    @Excel(name = "逻辑删除标识位")
    private Integer isDeleted;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
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
    public void setDeviceInStockBy(String deviceInStockBy) 
    {
        this.deviceInStockBy = deviceInStockBy;
    }

    public String getDeviceInStockBy() 
    {
        return deviceInStockBy;
    }
    public void setDeviceInStockTime(Date deviceInStockTime) 
    {
        this.deviceInStockTime = deviceInStockTime;
    }

    public Date getDeviceInStockTime() 
    {
        return deviceInStockTime;
    }
    public void setDeviceOutStockBy(String deviceOutStockBy) 
    {
        this.deviceOutStockBy = deviceOutStockBy;
    }

    public String getDeviceOutStockBy() 
    {
        return deviceOutStockBy;
    }
    public void setDeviceOutStockTime(Date deviceOutStockTime) 
    {
        this.deviceOutStockTime = deviceOutStockTime;
    }

    public Date getDeviceOutStockTime() 
    {
        return deviceOutStockTime;
    }
    public void setStockStatus(String stockStatus) 
    {
        this.stockStatus = stockStatus;
    }

    public String getStockStatus() 
    {
        return stockStatus;
    }
    public void setDeleteBy(String deleteBy) 
    {
        this.deleteBy = deleteBy;
    }

    public String getDeleteBy() 
    {
        return deleteBy;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }
    public AppSupplier getSupplier() {
        return supplier;
    }
    public AppProduct getProduct() {
        return product;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("productId", getProductId())
            .append("supplierId", getSupplierId())
            .append("deviceStatus", getDeviceStatus())
            .append("deviceCode", getDeviceCode())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deviceInStockBy", getDeviceInStockBy())
            .append("deviceInStockTime", getDeviceInStockTime())
            .append("deviceOutStockBy", getDeviceOutStockBy())
            .append("deviceOutStockTime", getDeviceOutStockTime())
            .append("stockStatus", getStockStatus())
            .append("deleteBy", getDeleteBy())
            .append("deleteTime", getDeleteTime())
            .append("isDeleted", getIsDeleted())
            .append("supplier", getSupplier())
            .append("product", getProduct())
            .toString();
    }
}
