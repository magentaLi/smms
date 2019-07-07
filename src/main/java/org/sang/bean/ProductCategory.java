package org.sang.bean;

import java.io.Serializable;

public class ProductCategory implements Serializable {
    //商品类别ID
    private Integer productCategoryId;
    //商品类别名称
    private String productCategoryName;

    public ProductCategory() {
    }

    public ProductCategory(Integer productCategoryId, String productCategoryName) {
        this.productCategoryId = productCategoryId;
        this.productCategoryName = productCategoryName;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }
}
