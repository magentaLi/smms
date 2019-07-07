package org.sang.controller;

import org.sang.bean.Delivery;
import org.sang.bean.Warehousing;
import org.sang.logger.SystemControllerLog;
import org.sang.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @SystemControllerLog(description = "新增出库单")
    @PostMapping("/api/post/delivery")
    public Map addDelivery(Delivery delivery) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.addDelivery(delivery);
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

    @SystemControllerLog(description = "通过出库单号删除出库单")
    @DeleteMapping("/api/delete/delivery/deliveryId")
    public Map deleteDeliveryBydId(Integer deliveryId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.deleteDeliveryBydId(deliveryId);
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

    @SystemControllerLog(description = "获取所有出库单")
    @GetMapping("/api/get/delivery")
    public HashMap getDeliverys(int index, int size, String deliveryId, String productCode) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Delivery> deliverys = deliveryService.getDeliverys(index, size, deliveryId, productCode);
        int deliverySize = deliveryService.getDeliverys(1, Integer.MAX_VALUE, deliveryId, productCode).size();
        int pages;
        if (deliverySize <= size) {
            pages = 1;
        } else {
            pages = deliverySize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", deliverySize);
        map.put("countOfPage", pages);
        map.put("deliverys", deliverys);
        return map;
    }

    @SystemControllerLog(description = "通过出库单号获取出库单")
    @GetMapping("/api/get/delivery/deliveryId")
    public Delivery getDeliveryById(Integer deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @SystemControllerLog(description = "更新出库单")
    @PutMapping("/api/put/delivery")
    public Map updateDelivery(Delivery delivery) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.updateDelivery(delivery);
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

}
