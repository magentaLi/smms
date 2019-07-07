package org.sang.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    //商品代码
    private String productCode;
    //商品名称
    private String productName;
    //商品类别代码
    private Integer productCategoryId;
    //商品生产日期
    private Date productionDate;
    //保质期
    private Integer guaranteePeriod;
    //商品价格
    private Double productPrice;
    //商品库存
    private Integer kucun;

    public Product(String productCode, String productName, Integer productCategoryId, Date productionDate, Integer guaranteePeriod, Double productPrice, Integer kucun) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategoryId = productCategoryId;
        this.productionDate = productionDate;
        this.guaranteePeriod = guaranteePeriod;
        this.productPrice = productPrice;
        this.kucun = kucun;
    }

    public Product() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(Integer guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategoryId=" + productCategoryId +
                ", productionDate=" + productionDate +
                ", guaranteePeriod=" + guaranteePeriod +
                ", productPrice=" + productPrice +
                ", kucun=" + kucun +
                '}';
    }
}
