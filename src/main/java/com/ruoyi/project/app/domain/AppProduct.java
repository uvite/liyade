package com.ruoyi.project.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品管理对象 app_product
 *
 * @author ruoyi
 * @date 2023-04-13
 */
public class AppProduct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    private Long productId;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String productName;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private String productType;

    /**
     * 供应商
     */
    @Excel(name = "供应商")
    private Long supplierId;

    /**
     * 产品编号
     */
    @Excel(name = "产品编号")
    private String productCode;

    /**
     * 参考价格
     */
    @Excel(name = "参考价格")
    private BigDecimal productPrice;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productCreateTime;

    /**
     * 更新者
     */
    private String deleteBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime;

    private Integer isDeleted;


    private AppSupplier supplier;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }


    public AppSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(AppSupplier supplier) {
        this.supplier = supplier;
    }


    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productId", getProductId())
                .append("productName", getProductName())
                .append("productType", getProductType())
                .append("supplierId", getSupplierId())
                .append("productCode", getProductCode())
                .append("productPrice", getProductPrice())
                .append("productCreateTime", getProductCreateTime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("deleteBy", getDeleteBy())
                .append("deleteTime", getDeleteTime())
                .append("isDeleted", getIsDeleted())
                .append("remark", getRemark())
                .append("supplier", getSupplier())
                .toString();
    }
}
