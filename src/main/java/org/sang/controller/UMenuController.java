package org.sang.controller;

import org.sang.bean.UMenu;
import org.sang.logger.SystemControllerLog;
import org.sang.service.UMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @SystemControllerLog(description = "查询所有的菜单")
    @GetMapping("/api/get/umenu")
    public ArrayList<UMenu> getAllUMenu() {
        ArrayList<UMenu> allUMenu = uMenuService.getAllUMenu();
        return allUMenu;
    }

    @SystemControllerLog(description = "修改角色菜单")
    @PutMapping("/api/put/roleUmenu")
    public Map putRoleUMenu(int roleId, String subMenuId) {
        HashMap<String, Object> map = new HashMap<>();
        int i = uMenuService.updateSubMenuForRole(roleId, subMenuId);
        map.put("isOK", true);
        map.put("msg", "修改成功");
        return map;
    }

    @SystemControllerLog(description = "查询角色的菜单")
    @GetMapping("/api/get/roleUMenu/{roleId}")
    public List getRUMenu(@PathVariable("roleId") int roleId) {
        return uMenuService.getSubMenuByRole(roleId);
    }

}
