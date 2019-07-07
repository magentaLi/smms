package org.sang.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.sang.bean.*;
import org.sang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;
    @Test
    public void getUserById(){
        User user = userService.getUserById(new Long(23232));
        System.out.println(user);
    }
    @Test
    public void  addUser(){
        User user = new User();
        user.setName("xiaoqi");
        user.setPhone("2313123");
        int num = userService.addUser(user);
        assertEquals(1,num);
    }
    @Test
    public void deleteUser(){
        int num = userService.deleteUser(new Long(42));
    }
    @Test
    public void updateUser(){
        User user = userService.getUserById(new Long(42));
        user.setAddress("SICHUAN");
        int num = userService.updateUser(user);
        assertEquals(1,num);
    }
}
