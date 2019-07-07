package org.sang.service;

import org.sang.bean.ProductCategory;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface ProductCategoryService {
    int countProductCategory(String productCategoryName);

    int addProductCategory(ProductCategory productCategory);

    ArrayList<ProductCategory> getProductCategory(int index, int size, String productCategoryName);

}
