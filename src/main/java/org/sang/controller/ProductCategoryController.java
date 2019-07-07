package org.sang.controller;

import org.sang.bean.ProductCategory;
import org.sang.logger.SystemControllerLog;
import org.sang.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author magentaLi
 */
@RestController
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @SystemControllerLog(description = "增加商品类别")
    @PostMapping("/api/post/productCategory")
    public Map addProductCategory(ProductCategory productCategory) {
        HashMap<String, Object> map = new HashMap<>();
        int i = productCategoryService.countProductCategory(productCategory.getProductCategoryName());
        if (i == 0) {
            productCategoryService.addProductCategory(productCategory);
            map.put("isOK", true);
            map.put("msg", "添加商品类别成功");
        } else {
            map.put("isOK", false);
            map.put("msg", "该商品类别已经存在，请勿重复添加！");
        }
        return map;
    }

    @SystemControllerLog(description = "分页获取商品类别列表")
    @GetMapping("/api/get/productCategory")
    public HashMap getRoles(int index, int size, String productCategoryName) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<ProductCategory> productCategories = productCategoryService.getProductCategory(index, size, productCategoryName);
        int categorySize = productCategoryService.getProductCategory(1, Integer.MAX_VALUE, productCategoryName).size();
        int pages;
        if (categorySize <= size) {
            pages = 1;
        } else {
            pages = categorySize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", categorySize);
        map.put("countOfPage", pages);
        map.put("productCategories", productCategories);
        return map;
    }


}
