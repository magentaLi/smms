package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Product;
import org.springframework.security.core.parameters.P;

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

}
