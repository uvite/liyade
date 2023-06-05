package com.ruoyi.project.app.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 供应商管理对象 app_supplier
 *
 * @author ruoyi
 * @date 2023-04-13
 */
public class AppSupplier extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long supplierId;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String supplierName;

    /**
     * 名称简写
     */
    @Excel(name = "名称简写")
    private String supplierShortName;

    /**
     * 标识
     */
    @Excel(name = "标识")
    private String supplierSign;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private String supplierLevel;

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 帐号状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName;
    }

    public String getSupplierShortName() {
        return supplierShortName;
    }

    public void setSupplierSign(String supplierSign) {
        this.supplierSign = supplierSign;
    }

    public String getSupplierSign() {
        return supplierSign;
    }

    public void setSupplierLevel(String supplierLevel) {
        this.supplierLevel = supplierLevel;
    }

    public String getSupplierLevel() {
        return supplierLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("supplierId", getSupplierId())
                .append("supplierName", getSupplierName())
                .append("supplierShortName", getSupplierShortName())
                .append("supplierSign", getSupplierSign())
                .append("supplierLevel", getSupplierLevel())
                .append("remark", getRemark())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
