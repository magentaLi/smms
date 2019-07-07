package org.sang.controller;

import org.sang.bean.ReturnGood;
import org.sang.logger.SystemControllerLog;
import org.sang.service.ReturnGoodService;
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
public class ReturnGoodController {

    @Autowired
    ReturnGoodService returnGoodService;

    @SystemControllerLog(description = "添加退货单")
    @PostMapping("/api/post/return")
    public Map insertReturnGood(ReturnGood returnGood) {
        HashMap<String, Object> map = new HashMap<>();
        int i = returnGoodService.addReturnGood(returnGood);
        Boolean isOK = false;
        String msg;
        if (i != 0) {
            isOK = true;
            msg = "添加退货单成功";
        } else {
            msg = "添加退货单失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    @SystemControllerLog(description = "分页获取退货单列表")
    @GetMapping("/api/get/return")
    public HashMap getUsers(int index, int size, String productCode, String startDate, String endDate) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<ReturnGood> returnGoods = returnGoodService.getReturnGood(index, size, productCode, startDate, endDate);
        int returnGoodsSize = returnGoodService.getReturnGood(1, Integer.MAX_VALUE, productCode, startDate, endDate).size();
        int pages;
        if (returnGoodsSize <= size) {
            pages = 1;
        } else {
            pages = returnGoodsSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", returnGoodsSize);
        map.put("countOfPage", pages);
        map.put("allReturnGoods", returnGoods);
        return map;
    }

}
