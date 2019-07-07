package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Product;
import org.sang.bean.User;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

/**
 * @author magentaLi
 */
@Mapper
public interface ProductMapper {

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

    ArrayList<Product> getProduct(@Param("index") int index, @Param("size") int size, @Param("productCode") String productCode, @Param("productName") String productName, @Param("productCategoryName") String productCategoryName);


}
