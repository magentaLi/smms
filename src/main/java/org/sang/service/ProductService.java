package org.sang.service;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Product;
import org.sang.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    //添加商品
    int addProduct(Product product);

    //删除商品
    int deleteProduct(@Param("productCode") String productCode);

    //修改商品
    int updateProduct(Product product);

    //查询所有商品
    List<Product> getAllProduct();

    //查询单个商品
    Product getProductByProductCode(@Param("productCode") String productCode);

    ArrayList<Product> getProducts(int index, int size, String productCode, String productName, String productCategoryName);

}
