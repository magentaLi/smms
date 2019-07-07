package org.sang.bean;

import java.io.Serializable;

/**
 * @author magentaLi
 * 耗损类
 */
public class Wastage implements Serializable {
    private Integer id;
    private String productCode;
    private Integer addOrSub;
    private Integer num;
    private String reason;

    public Wastage(Integer id, String productCode, Integer addOrSub, Integer num, String reason) {
        this.id = id;
        this.productCode = productCode;
        this.addOrSub = addOrSub;
        this.num = num;
        this.reason = reason;
    }

    public Wastage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getAddOrSub() {
        return addOrSub;
    }

    public void setAddOrSub(Integer addOrSub) {
        this.addOrSub = addOrSub;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Wastage{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", addOrSub=" + addOrSub +
                ", num=" + num +
                ", reason='" + reason + '\'' +
                '}';
    }
}
