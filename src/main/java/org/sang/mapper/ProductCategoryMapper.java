package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.ProductCategory;

import java.util.ArrayList;

/**
 * @author magentaLi
 */

@Mapper
public interface ProductCategoryMapper {
    int countProductCategoryByName(String productCategoryName);

    int addProductCategory(ProductCategory productCategory);

    ArrayList<ProductCategory> getProductCategory(@Param("index") int index, @Param("size") int size, @Param("productCategoryName") String productCategoryName);

}
