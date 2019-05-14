package org.sang.controller;

import org.sang.bean.BusinessLog;
import org.sang.bean.User;
import org.sang.logger.SystemControllerLog;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author magentaLi
 */

@Controller
public class LogController {

    @Autowired
    UserService userService;

    @SystemControllerLog(description = "获取登陆日志")
    @GetMapping("/api/get/getLoginLog")
    public HashMap getLoginLog() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
//            FileReader fr = new FileReader("D:\\IDEA-WorkSpace\\smms\\log\\login\\smms_login.log");
            FileReader fr = new FileReader("/log/login/smms_login.log");
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
        return map;
    }

    @SystemControllerLog(description = "获取业务日志")
    @GetMapping("/api/get/getBusinessLog")
    public HashMap getBusinessLog() {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
//            FileReader fr = new FileReader("D:\\IDEA-WorkSpace\\smms\\log\\bussiness\\smms_bussiness.log");
            FileReader fr = new FileReader("/log/bussiness/smms_bussiness.log");
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
        ArrayList<BusinessLog> logs = new ArrayList<>();
        for (String str : arrayList) {
            String substring = str.substring(83);
            String[] s = substring.split("_");
            BusinessLog businessLog = new BusinessLog(s[0], s[1], s[2], s[4]);
            logs.add(businessLog);
        }
        map.put("businessLog", logs);
        return map;
    }
}
