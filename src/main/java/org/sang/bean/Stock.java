package org.sang.bean;

import java.io.Serializable;

public class Stock implements Serializable {
    private String productCode;
    private String productName;
    private Integer productCount;

    public Stock() {
    }

    public Stock(String productCode, String productName, Integer productCount) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCount = productCount;
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

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
