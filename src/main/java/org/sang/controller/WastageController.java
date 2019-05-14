package org.sang.controller;

import org.sang.bean.Wastage;
import org.sang.logger.SystemControllerLog;
import org.sang.service.WastageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author magentaLi
 */
@Controller
public class WastageController {
    @Autowired
    WastageService wastageService;

    @SystemControllerLog(description = "查询耗损情况")
    @GetMapping("/api/get/wastage")
    public HashMap getAllWastage() {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Wastage> allWastage = wastageService.getAllWastage();
        map.put("size", allWastage.size());
        map.put("data", allWastage);
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
        if (i != 0) {
            isOK = true;
        }
        map.put("isOK", isOK);
        return map;
    }
}
