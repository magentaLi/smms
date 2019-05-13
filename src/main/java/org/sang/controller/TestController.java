package org.sang.controller;

import org.sang.bean.User;
import org.sang.logger.SystemControllerLog;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    @Autowired
    UserService userService;

    @GetMapping("/getLoginLog")
    public HashMap getLoginLog() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\IDEA-WorkSpace\\smms\\log\\login\\smms_login.log");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String patternStr1 = "[0-9]{4}[-][0-9]{1,2}[-][0-9]{1,2}[ ][0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2}";
        String patternStr2 = "(?<=\').*?(?=\')";
        Pattern pattern1 = Pattern.compile(patternStr1);
        Pattern pattern2 = Pattern.compile(patternStr2);
        HashMap<String, User> map = new HashMap<>();
        String time = null;
        String name = null;
        for (String str : arrayList) {
            Matcher matcher1 = pattern1.matcher(str);
            if (matcher1.find()) {
                time = matcher1.group();
            }
            Matcher matcher2 = pattern2.matcher(str);
            if (matcher2.find()) {
                name = matcher2.group();
            }
            User user = userService.getUserByName(name);
            map.put(time, user);
        }
        Set<String> strings = map.keySet();
        for (String s : strings) {
            User s1 = map.get(s);
            System.out.println("key=" + s + " " + "value=" + s1);
        }
        return map;
    }
}
