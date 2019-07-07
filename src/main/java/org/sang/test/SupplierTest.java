package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Delivery;
import org.sang.bean.Supplier;
import org.sang.mapper.SupplierMapper;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.sang.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierTest {
    @Autowired
    SupplierService supplierService;
    @Test
    public void addSupplier(){
        Supplier supplier = new Supplier("23132132","XIAOQI","SICHUAN","18398746998","1342709554@qq.com","23123",1,232.0);
        int num = supplierService.addSupplier(supplier);
        assertEquals(1,num);
    }
    @Test
    public void deleteSupplier(){
        int num = supplierService.deleteSupplier("23132132");
        assertEquals(1,num);
    }
    @Test
    public void updateSupplier(){
        Supplier supplier = new Supplier("23132132","BAOQI","SICHUAN","18398746998","1342709554@qq.com","23123",1,232.0);
        int num = supplierService.updateSupplier(supplier);
    }
    @Test
    public void getAllSupplier(){
        List<Supplier> suppliers = supplierService.getAllSupplier();
        for(int i=0;i<suppliers.size();i++){
            System.out.println(suppliers.get(i));
        }
    }
    @Test
    public void getSupplierById(){
        Supplier supplier =  supplierService.getSupplierBySupplierCode("23132132");
        System.out.println(supplier);
    }
    @Autowired
    SupplierMapper supplierMapper;
    @Test
    public void getSuppliers(){
       List<Supplier> supplier =  supplierMapper.getSuppliers(0,5,"百事可乐供应商","0");
       for(int i=0;i<supplier.size();i++){
           System.out.println(i);
           System.out.println(supplier.get(i));
       }
    }
}
