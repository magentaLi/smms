package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Delivery;
import org.sang.bean.Warehousing;
import org.sang.bean.Wastage;
import org.sang.mapper.WastageMapper;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.sang.service.WarehousingService;
import org.sang.service.WastageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WastageTest {
    @Autowired
    WastageService wastageService;
    @Test
    public void getAllWastage(){
        List<Wastage> wastages = wastageService.getAllWastage();
        for(int i=0;i<wastages.size();i++){
            System.out.println(wastages.get(i));
        }
    }
    @Test
    public void getWastage(){
        List<Wastage> wastages = wastageService.getWastageByProductCode("11111111");
        for(int i=0;i<wastages.size();i++){
            System.out.println(wastages.get(i));
        }
    }
    @Test
    public void addWastage(){
        Wastage wastage = new Wastage(1234321,"11111111",0,100,"mice");
        int num = wastageService.addWastage(wastage);
        assertEquals(1,num);
    }
    @Autowired
    WastageMapper wastageMapper;
    @Test
    public void getWasteages(){
       System.out.println(wastageMapper.getWastages(0,5,"可乐","11111111"));
    }
}
