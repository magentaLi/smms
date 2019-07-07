package org.sang.controller;

import org.sang.bean.User;
import org.sang.bean.Wastage;
import org.sang.logger.SystemControllerLog;
import org.sang.service.WastageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author magentaLi
 */
@RestController
public class WastageController {
    @Autowired
    WastageService wastageService;

    @SystemControllerLog(description = "查询耗损情况")
    @GetMapping("/api/get/wastage")
    public HashMap getWastage(int index, int size, String productName, String productCode) {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Wastage> wastages = wastageService.getWastages(index, size, productName, productCode);
        int wastageSize = wastageService.getWastages(1, Integer.MAX_VALUE, productName, productCode).size();
        int pages;
        if (wastageSize <= size) {
            pages = 1;
        } else {
            pages = wastageSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", wastageSize);
        map.put("countOfPage", pages);
        map.put("wastages", wastages);
        return map;
    }

    @SystemControllerLog(description = "通过商品代码查询耗损情况")
    @GetMapping("/api/get/wastage/{productCode}")
    public HashMap getWastage(@PathVariable("productCode") String productCode) {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Wastage> allWastage = wastageService.getWastageByProductCode(productCode);
        map.put("size", allWastage.size());
        map.put("data", allWastage);
        return map;
    }

    @SystemControllerLog(description = "添加耗损情况")
    @PostMapping("/api/post/wastage")
    public HashMap addWastage(Wastage wastage) {
        HashMap<String, Object> map = new HashMap<>();
        int i = wastageService.addWastage(wastage);
        Boolean isOK = false;
        String msg;
        if (i != 0) {
            isOK = true;
            msg = "添加成功";
        } else {
            isOK = false;
            msg = "添加失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }
}
