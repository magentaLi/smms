package org.sang.controller;

import org.sang.bean.UMenu;
import org.sang.logger.SystemControllerLog;
import org.sang.service.UMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UMenuController {


    @Autowired
    UMenuService uMenuService;

    //根据userID查询一级二级菜单
    @SystemControllerLog(description = "根据用户名查询一级和二级菜单")
    @GetMapping("/api/Menu")
    public List<UMenu> getUMenuById(Integer id) {
        List<UMenu> uMenus = uMenuService.getUMenuById(id);
        return uMenus;
    }

}
