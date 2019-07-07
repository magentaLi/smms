package org.sang.service;

import org.sang.bean.Product;
import org.sang.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public int deleteProduct(String productCode) {
        return productMapper.deleteProduct(productCode);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public Product getProductByProductCode(String productCode) {
        return productMapper.getProductByProductCode(productCode);
    }

    @Override
    public ArrayList<Product> getProducts(int index, int size, String productCode, String productName, String productCategoryName) {
        int currentPage = (index - 1) * size;
        return productMapper.getProduct(currentPage, size, productCode, productName, productCategoryName);
    }

}
