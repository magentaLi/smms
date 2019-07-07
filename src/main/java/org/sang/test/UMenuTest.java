package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Delivery;
import org.sang.mapper.DeliveryMapper;
import org.sang.mapper.UMenuMapper;
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
public class UMenuTest {
    @Autowired
    UMenuMapper uMenuMapper;
    @Test
    public void getSubMenuByRole(){
        System.out.println(uMenuMapper.getSubMenuByRole(6));
    }
}
