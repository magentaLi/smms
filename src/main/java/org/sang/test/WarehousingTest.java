package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Delivery;
import org.sang.bean.Warehousing;
import org.sang.mapper.WarehousingMapper;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.sang.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WarehousingTest {
    @Autowired
    WarehousingService warehousingService;
    @Test
    public void addWarehousing(){
       Warehousing warehousing = new Warehousing(6543217,"11111111","31431223",new Date(),33.0,100,33.0);
       int num = warehousingService.addWarehousing(warehousing);
       assertEquals(1,num);
    }
    @Test
    public void deleteWarehousing(){
        int num = warehousingService.deleteWarehousingBydId(6543217);
        assertEquals(1,num);
    }
    @Test
    public void updateWarehousing(){
        Warehousing warehousing = new Warehousing(6543217,"11111111","33425433",new Date(),33.0,1,33.0);
        int num = warehousingService.updateWarehousing(warehousing);
        assertEquals(1,num);
    }
    @Test
    public void getAllWarehousings(){
        List<Warehousing> warehousings = warehousingService.getWarehousing();
        for(int i=0;i<warehousings.size();i++){
            System.out.println(warehousings.get(i));
        }
    }
    @Autowired
    WarehousingMapper warehousingMapper;
    @Test
    public void getWarehousings(){
      List<Warehousing> warehousings =  warehousingMapper.getWarehousings(0,5,"","11","");
      for(int i=0;i<warehousings.size();i++){
          System.out.println(i+"-----------------");
          System.out.println(warehousings.get(i));
      }
    }
}
