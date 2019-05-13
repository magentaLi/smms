package org.sang.bean;

public class ReturnGood {
    private Integer returnGoodsId;
    private String productCode;
    private Integer returnCount;
    private  String  returnReason;

    public ReturnGood() {

    }

    public ReturnGood(Integer returnGoodsId, String productCode, Integer returnCount, String returnReason) {
        this.returnGoodsId = returnGoodsId;
        this.productCode = productCode;
        this.returnCount = returnCount;
        this.returnReason = returnReason;
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

    @Override
    public String toString() {
        return "ReturnGood{" +
                "returnGoodsId=" + returnGoodsId +
                ", productCode='" + productCode + '\'' +
                ", returnCount=" + returnCount +
                ", returnReason='" + returnReason + '\'' +
                '}';
    }
}
