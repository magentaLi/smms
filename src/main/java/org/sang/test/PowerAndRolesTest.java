package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.sang.bean.Delivery;
import org.sang.bean.Menu;
import org.sang.bean.Role;
import org.sang.service.DeliveryService;
import org.sang.service.DeliveryServiceImpl;
import org.sang.service.PowerAndRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerAndRolesTest {
    @Autowired
    PowerAndRolesService powerAndRolesService;
    @Test
    public void addRoles(){
        int num = powerAndRolesService.addRole("sales","销售");
        assertEquals(1,num);
    }
    @Test
    public void getAllRoles(){
        List<Role> roles = powerAndRolesService.getAllRole();
        for(int i=0;i<roles.size();i++){
            System.out.println(roles.get(i));
        }
    }
    @Test
    public void getMenu(){
        List<Menu> menus = powerAndRolesService.getAllMenu();
        for(int i=0;i<menus.size();i++){
            System.out.println(menus.get(i));
        }
    }
}
