package org.sang.bean;

import java.io.Serializable;

public class Supplier implements Serializable {
    private String supplierCode;
    private String supplierName;
    private String supplierAddress;
    private String supplierTel;
    private String supplierEMail;
    private String supplierFax;
    private Integer supplierReputation;
    private Double supplierLoan;

    public Supplier() {
    }

    public Supplier(String supplierCode, String supplierName, String supplierAddress, String supplierTel, String supplierEMail, String supplierFax, Integer supplierReputation, Double supplierLoan) {
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierTel = supplierTel;
        this.supplierEMail = supplierEMail;
        this.supplierFax = supplierFax;
        this.supplierReputation = supplierReputation;
        this.supplierLoan = supplierLoan;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierEMail() {
        return supplierEMail;
    }

    public void setSupplierEMail(String supplierEMail) {
        this.supplierEMail = supplierEMail;
    }

    public String getSupplierFax() {
        return supplierFax;
    }

    public void setSupplierFax(String supplierFax) {
        this.supplierFax = supplierFax;
    }

    public Integer getSupplierReputation() {
        return supplierReputation;
    }

    public void setSupplierReputation(Integer supplierReputation) {
        this.supplierReputation = supplierReputation;
    }

    public Double getSupplierLoan() {
        return supplierLoan;
    }

    public void setSupplierLoan(Double supplierLoan) {
        this.supplierLoan = supplierLoan;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierTel='" + supplierTel + '\'' +
                ", supplierEMail='" + supplierEMail + '\'' +
                ", supplierFax='" + supplierFax + '\'' +
                ", supplierReputation=" + supplierReputation +
                ", supplierLoan=" + supplierLoan +
                '}';
    }
}
