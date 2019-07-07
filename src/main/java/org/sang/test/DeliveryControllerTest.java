package org.sang.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DeliveryControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        //       mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }
    @Test
    public void addDelivery() throws Exception {
        HashMap<String,Object> param = new HashMap<String, Object>();
        param.put("deliveryId","1234321");
        param.put("productCode","1223343");
        param.put("deliveryObj","XXX");
        param.put("deliveryDate","1998-08-15");
        param.put("productPrice",33.0);
        param.put("productCount",1);
        param.put("paidMoney",33.0);
        String res = mvc.perform(MockMvcRequestBuilders.post("/api/post/delivery")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(param.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        JSONObject ss = JSON.parseObject("res");
        Boolean resCode = ss.getBoolean("isOK");
        assertEquals(true,resCode);
    }

    @Test
    public void deleteDeliveryBydId() {
    }

    @Test
    public void updateDelivery() {
    }
}