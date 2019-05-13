package org.sang.controller;

import org.sang.bean.Delivery;
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

    @PostMapping("/api/post/delivery")
    public Map addDelivery(Delivery delivery) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.addDelivery(delivery);
        Boolean isOK = true;
        String info = "添加成功";
        if (res == 0) {
            isOK = false;
            info = "添加失败";
        }
        map.put("isOK", isOK);
        map.put("info", info);
        return map;
    }

    @DeleteMapping("/api/delete/supplier")
    public Map deleteDeliveryBydId(Integer deliveryId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.deleteDeliveryBydId(deliveryId);
        String info = "删除成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            info = "删除失败";
        }
        map.put("isOK", isOK);
        map.put("info", info);
        return map;
    }

    @GetMapping("/api/get/delivery")
    List<Delivery> getDelivery() {
        return deliveryService.getDelivery();
    }

    @GetMapping("/api/get/delivery/deliveryId")
    Delivery getDeliveryById(Integer deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @PutMapping("/api/put/delivery")
    public Map updateDelivery(Delivery delivery) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = deliveryService.updateDelivery(delivery);
        String info = "修改成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            info = "修改失败";
        }
        map.put("isOK", isOK);
        map.put("info", info);
        return map;
    }

}
