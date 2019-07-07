package org.sang.service;

import org.sang.bean.ProductCategory;
import org.sang.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public int countProductCategory(String productCategoryName) {
        return productCategoryMapper.countProductCategoryByName(productCategoryName);
    }

    @Override
    public int addProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.addProductCategory(productCategory);
    }

    @Override
    public ArrayList<ProductCategory> getProductCategory(int index, int size, String productCategoryName) {
        int currentPage = (index - 1) * size;
        return productCategoryMapper.getProductCategory(currentPage, size, productCategoryName);
    }
}
