package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.sang.bean.Delivery;
import org.sang.bean.Menu;
import org.sang.bean.ReturnGood;
import org.sang.bean.Role;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.sang.service.PowerAndRolesService;
import org.sang.service.ReturnGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReturnGoodTest {
    @Autowired
    ReturnGoodService returnGoodService;
    @Test
    public void addReturnGood(){
        ReturnGood returnGood = new ReturnGood(1234321,"11111111",4,"null",new Date());
        int num = returnGoodService.addReturnGood(returnGood);
        assertEquals(1,num);
    }
}
