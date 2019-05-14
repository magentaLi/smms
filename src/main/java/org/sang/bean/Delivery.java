package org.sang.bean;

import java.util.Date;

public class Delivery {
    private Integer deliveryId;
    private String productCode;
    private String deliveryObj;
    private Date deliveryDate;
    private Double productPrice;
    private Integer productCount;
    private Double paidMoney;

    public Delivery() {
    }

    public Delivery(Integer deliveryId, String productCode, String deliveryObj, Date deliveryDate, Double productPrice, Integer productCount, Double paidMoney) {
        this.deliveryId = deliveryId;
        this.productCode = productCode;
        this.deliveryObj = deliveryObj;
        this.deliveryDate = deliveryDate;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.paidMoney = paidMoney;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDeliveryObj() {
        return deliveryObj;
    }

    public void setDeliveryObj(String deliveryObj) {
        this.deliveryObj = deliveryObj;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", productCode='" + productCode + '\'' +
                ", deliveryObj='" + deliveryObj + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", paidMoney=" + paidMoney +
                '}';
    }
}
