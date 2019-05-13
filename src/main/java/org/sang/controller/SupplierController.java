package org.sang.controller;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Supplier;
import org.sang.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierController {

    @Autowired
    SupplierService supplierService;

    //添加供应商
    @PostMapping("/api/post/supplier")
    public Map addSupplier(Supplier supplier) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.addSupplier(supplier);
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

    //删除供应商
    @DeleteMapping("/api/delete/supplier")
    public Map deleteSupplier(@Param("supplierCode") String supplierCode) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.deleteSupplier(supplierCode);
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

    //修改供应商
    @PutMapping("/api/put/supplier")
    public Map updateSupplier(Supplier supplier) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = supplierService.updateSupplier(supplier) ;
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

    //查询所有供应商
    @GetMapping("/api/get/supplier")
    public List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    //查询单个供应商
    @GetMapping("/api/get/supplier/supplierCode")
    public Supplier getSupplierBySupplierCode(@Param("supplierCode") String supplierCode) {
        return supplierService.getSupplierBySupplierCode(supplierCode);
    }
}
