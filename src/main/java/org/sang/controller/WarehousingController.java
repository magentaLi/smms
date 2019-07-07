package org.sang.controller;

import org.sang.bean.User;
import org.sang.bean.Warehousing;
import org.sang.logger.SystemControllerLog;
import org.sang.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WarehousingController {

    @Autowired
    WarehousingService warehousingService;

    /**
     * chenxi
     *
     * @param warehousing
     * @return true/false
     */
    @SystemControllerLog(description = "添加入库单")
    @PostMapping("/api/post/warehousing")
    public Map addWarehousing(Warehousing warehousing) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.addWarehousing(warehousing);
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

    /**
     * chenxi
     *
     * @param warehousingId
     * @return true/false
     */
    @SystemControllerLog(description = "通过入库单号删除入库单")
    @DeleteMapping("/api/delete/warehousing/{warehousingId}")
    public Map deleteWarehousingBydId(@PathVariable("warehousingId") Integer warehousingId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.deleteWarehousingBydId(warehousingId);
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

//    /**
//     * chenxi
//     *
//     * @return 所有入库单
//     */
//    @SystemControllerLog(description = "查询所有入库单")
//    @GetMapping("/api/get/warehousing")
//    public List<Warehousing> getWarehousing() {
//        return warehousingService.getWarehousing();
//    }

//    /**
//     * chenxi
//     *
//     * @param warehousingId
//     * @return 单个入库单
//     */
//    @SystemControllerLog(description = "通过入库单号查询入库单")
//    @GetMapping("/api/get/warehousing/warehousingId")
//    public Warehousing getWarehousingById(Integer warehousingId) {
//        return warehousingService.getWarehousingById(warehousingId);
//    }

    /**
     * chenxi
     *
     * @param warehousing
     * @return true/false
     */
    @SystemControllerLog(description = "更新入库单")
    @PutMapping("/api/put/warehousing")
    public Map updateWarehousing(Warehousing warehousing) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = warehousingService.updateWarehousing(warehousing);
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

    @SystemControllerLog(description = "分页获取入库单列表")
    @GetMapping("/api/get/warehousing")
    public HashMap getWarehousings(int index, int size, String warehousingId, String productCode, String supplierCode) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Warehousing> warehousings = warehousingService.getWarehousings(index, size, warehousingId, productCode, supplierCode);
        int warehousingSize = warehousingService.getWarehousings(1, Integer.MAX_VALUE, warehousingId, productCode, supplierCode).size();
        int pages;
        if (warehousingSize <= size) {
            pages = 1;
        } else {
            pages = warehousingSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", warehousingSize);
        map.put("countOfPage", pages);
        map.put("warehousings", warehousings);
        return map;
    }
}
