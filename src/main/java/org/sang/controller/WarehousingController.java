package org.sang.controller;

import org.sang.bean.Warehousing;
import org.sang.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehousingController {

    @Autowired
    WarehousingService warehousingService;

    /**
     * chenxi
     * @param warehousing
     * @return true/false
     */
    @PostMapping("/api/post/warehousing")
    public Map addWarehousing(Warehousing warehousing) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.addWarehousing(warehousing);
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

    /**
     * chenxi
     * @param warehousingId
     * @return true/false
     */
    @DeleteMapping("/api/delete/warehousing/warehousingId")
    public Map deleteWarehousingBydId(Integer warehousingId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.deleteWarehousingBydId(warehousingId);
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

    /**
     * chenxi
     * @return 所有入库单
     */
    @GetMapping("/api/get/warehousing")
    public List<Warehousing> getWarehousing() {
        return warehousingService.getWarehousing();
    }

    /**
     * chenxi
     * @param warehousingId
     * @return 单个入库单
     */
    @GetMapping("/api/get/warehousing/warehousingId")
    public Warehousing getWarehousingById(Integer warehousingId) {
        return warehousingService.getWarehousingById(warehousingId);
    }

    /**
     * chenxi
     * @param warehousing
     * @return true/false
     */
    @PutMapping("/api/put/warehousing")
    public Map updateWarehousing(Warehousing warehousing) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.updateWarehousing(warehousing);
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
