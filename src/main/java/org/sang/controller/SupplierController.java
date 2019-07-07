package org.sang.controller;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Supplier;
import org.sang.bean.User;
import org.sang.logger.SystemControllerLog;
import org.sang.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    //添加供应商
    @SystemControllerLog(description = "添加供应商")
    @PostMapping("/api/post/supplier")
    public Map addSupplier(Supplier supplier) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.addSupplier(supplier);
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

    //删除供应商
    @SystemControllerLog(description = "删除供应商")
    @DeleteMapping("/api/delete/supplier")
    public Map deleteSupplier(@Param("supplierCode") String supplierCode) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.deleteSupplier(supplierCode);
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

    //修改供应商
    @SystemControllerLog(description = "修改供应商")
    @PutMapping("/api/put/supplier")
    public Map updateSupplier(Supplier supplier) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.updateSupplier(supplier);
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

//    //查询所有供应商
//    @SystemControllerLog(description = "查询所有供应商")
//    @GetMapping("/api/get/supplier")
//    public List<Supplier> getAllSupplier() {
//        return supplierService.getAllSupplier();
//    }

    //查询单个供应商
    @SystemControllerLog(description = "查询单个供应商")
    @GetMapping("/api/get/supplier/supplierCode")
    public Supplier getSupplierBySupplierCode(@Param("supplierCode") String supplierCode) {
        return supplierService.getSupplierBySupplierCode(supplierCode);
    }

    @SystemControllerLog(description = "分页获取供应商列表")
    @GetMapping("/api/get/supplier")
    public HashMap getSuppliers(int index, int size, String supplierName, String supplierReputation) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Supplier> suppliers = supplierService.getSuppliers(index, size, supplierName, supplierReputation);
        int suppliersSize = supplierService.getSuppliers(1, Integer.MAX_VALUE, supplierName, supplierReputation).size();
        int pages;
        if (suppliersSize <= size) {
            pages = 1;
        } else {
            pages = suppliersSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", suppliersSize);
        map.put("countOfPage", pages);
        map.put("suppliers", suppliers);
        return map;
    }
}
