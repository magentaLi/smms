package org.sang.bean;

import java.util.Date;

public class Product {
    private String productCode;
    private String productName;
    private Integer productCategoryId;
    private Date productionDate;
    private Integer guaranteePeriod;
    private Double productPrice;
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
