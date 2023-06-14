package com.ruoyi.project.app.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.app.domain.AppSupplier;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品管理对象 app_product
 *
 * @author ruoyi
 * @date 2023-04-13
 */
public class Product  {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    private Long productId;

    /**
     * 名称
     */
//    @JsonAlias({"name"})
    @JsonProperty("name")
    @Excel(name = "名称")
    private String productName;



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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productId", getProductId())
                .append("name", getProductName())
                .toString();
    }
}
