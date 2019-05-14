package org.sang.bean;

import java.util.Date;

/**
 * 退回表类
 */
public class ReturnGood {
    //退货表ID
    private Integer returnGoodsId;
    //商品代码
    private String productCode;
    //退货数量
    private Integer returnCount;
    //退货原因
    private String returnReason;
    //退货日期
    private Date returnDate;

    public ReturnGood(Integer returnGoodsId, String productCode, Integer returnCount, String returnReason, Date returnDate) {
        this.returnGoodsId = returnGoodsId;
        this.productCode = productCode;
        this.returnCount = returnCount;
        this.returnReason = returnReason;
        this.returnDate = returnDate;
    }

    public ReturnGood() {
    }

    public Integer getReturnGoodsId() {
        return returnGoodsId;
    }

    public void setReturnGoodsId(Integer returnGoodsId) {
        this.returnGoodsId = returnGoodsId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(Integer returnCount) {
        this.returnCount = returnCount;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "ReturnGood{" +
                "returnGoodsId=" + returnGoodsId +
                ", productCode='" + productCode + '\'' +
                ", returnCount=" + returnCount +
                ", returnReason='" + returnReason + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
