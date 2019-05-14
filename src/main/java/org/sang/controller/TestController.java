package org.sang.controller;


import org.sang.logger.SystemControllerLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author magentaLi
 */

@RestController
public class TestController {

    @SystemControllerLog(description = "测试")
    @GetMapping("/test")
    public HashMap test(String list) {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(list);
        return map;
    }
}
