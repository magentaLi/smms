package org.sang.bean;

import java.io.Serializable;
import java.util.Date;

public class Warehousing implements Serializable {
    private Integer warehousingId;
    private String productCode;
    private String supplierCode;
    private Date warehousingDate;
    private Double productPrice;
    private Integer productCount;
    private Double paidMoney;

    public Warehousing() {
    }

    public Warehousing(Integer warehousingId, String productCode, String supplierCode, Date warehousingDate, Double productPrice, Integer productCount, Double paidMoney) {
        this.warehousingId = warehousingId;
        this.productCode = productCode;
        this.supplierCode = supplierCode;
        this.warehousingDate = warehousingDate;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.paidMoney = paidMoney;
    }

    public Integer getWarehousingId() {
        return warehousingId;
    }

    public void setWarehousingId(Integer warehousingId) {
        this.warehousingId = warehousingId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Date getWarehousingDate() {
        return warehousingDate;
    }

    public void setWarehousingDate(Date warehousingDate) {
        this.warehousingDate = warehousingDate;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(Double paidMoney) {
        this.paidMoney = paidMoney;
    }

    @Override
    public String toString() {
        return "Warehousing{" +
                "warehousingId=" + warehousingId +
                ", productCode='" + productCode + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", warehousingDate=" + warehousingDate +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", paidMoney=" + paidMoney +
                '}';
    }
}
