package org.sang.controller;

import org.sang.bean.Delivery;
import org.sang.logger.SystemControllerLog;
import org.sang.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    List<Delivery> getDelivery() {
        return deliveryService.getDelivery();
    }

    @SystemControllerLog(description = "通过出库单号获取出库单")
    @GetMapping("/api/get/delivery/deliveryId")
    Delivery getDeliveryById(Integer deliveryId) {
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
