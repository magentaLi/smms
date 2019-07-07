package org.sang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Delivery;
import org.sang.mapper.DeliveryMapper;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveryTest {
    @Autowired
    DeliveryService deliveryService;
    @Test
    public void addDelivery() throws Exception {
        Delivery delivery = new Delivery(5435321,"11111111","XXX",new Date(),33.0,100,33.0);
        int num = deliveryService.addDelivery(delivery);
        assertEquals(1,num);
    }
    @Test
    public void deleteDelivery() throws Exception{
        int num = deliveryService.deleteDeliveryBydId(1234321);
        assertEquals(1,num);
    }
    @Test
    public void updateDelivery() throws Exception{
        Delivery delivery = new Delivery(1234321,"22223311","YYYY",new Date(),33.0,1,33.0);
        int num = deliveryService.updateDelivery(delivery);
        assertEquals(1,num);
    }
    @Test
    public void getDelivery() throws Exception{
       List<Delivery> deliveries =  deliveryService.getDelivery();
       for(int i=0;i<deliveries.size();i++){
           System.out.println(deliveries.get(i));
       }
    }
    @Test
    public void getDeliveryById() throws Exception{
        Delivery delivery = deliveryService.getDeliveryById(1234321);
        System.out.println(delivery);
    }
    @Autowired
    DeliveryMapper deliveryMapper;
    @Test
    public void getDeliverys(){
      List<Delivery> deliveries = deliveryMapper.getDeliverys(0,5,"1234321","1223343");
      for(int i=0;i<deliveries.size();i++){
          System.out.println(deliveries.get(i));
      }
    }
}
