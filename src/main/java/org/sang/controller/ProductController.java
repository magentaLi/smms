package org.sang.controller;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Product;
import org.sang.logger.SystemControllerLog;
import org.sang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;

    //添加商品
    @PostMapping("/api/post/product")
    public Map addProduct(Product product) {

        HashMap<Object, Object> map = new HashMap<>();
        int res = productService.addProduct(product);
        Boolean isOK = true;
        String msg = "添加成功";
        if (res == 0) {
            isOK = false;
            msg = "添加失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    //删除商品
    @DeleteMapping("/api/delete/product/{productCode}")
    public Map deleteProduct(@PathVariable("productCode") String productCode) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = productService.deleteProduct(productCode);
        String msg = "删除成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            msg = "删除失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    //修改商品
    @PutMapping("/api/put/product")
    public Map updateProduct(Product product) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = productService.updateProduct(product);
        String msg = "修改成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            msg = "修改失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    @SystemControllerLog(description = "分页获取商品列表")
    @GetMapping("/api/get/product")
    public HashMap getProducts(int index, int size, String productCode, String productName, String productCategoryName) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Product> products = productService.getProducts(index, size, productCode, productName, productCategoryName);
        int productSize = productService.getProducts(1, Integer.MAX_VALUE, productCode, productName, productCategoryName).size();
        int pages;
        if (productSize <= size) {
            pages = 1;
        } else {
            pages = productSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", productSize);
        map.put("countOfPage", pages);
        map.put("products", products);
        return map;
    }

}
