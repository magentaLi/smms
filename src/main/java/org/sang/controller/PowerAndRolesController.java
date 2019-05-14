package org.sang.controller;

import org.sang.bean.Menu;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.logger.SystemControllerLog;
import org.sang.service.PowerAndRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author magentaLi
 */
@RestController
public class PowerAndRolesController {

    @Autowired
    PowerAndRolesService powerAndRolesService;

    @SystemControllerLog(description = "获取权限列表")
    @GetMapping("/api/get/menu")
    public HashMap getAllPower() {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Menu> allMenu = powerAndRolesService.getAllMenu();
        ArrayList<Menu> adminMenu = new ArrayList<>();
        ArrayList<Menu> productMenu = new ArrayList<>();
        ArrayList<Menu> powerMenu = new ArrayList<>();
        ArrayList<Menu> wareHousingMenu = new ArrayList<>();
        ArrayList<Menu> deliveryMenu = new ArrayList<>();
        ArrayList<Menu> supplierMenu = new ArrayList<>();
        for (Menu m : allMenu) {
            String category = (String) m.getComponent();
            if (category.equals("管理员权限")) {
                adminMenu.add(m);
            } else if (category.equals("商品相关权限")) {
                productMenu.add(m);
            } else if (category.equals("权限相关权限")) {
                powerMenu.add(m);
            } else if (category.equals("入库相关权限")) {
                wareHousingMenu.add(m);
            } else if (category.equals("出库相关权限")) {
                deliveryMenu.add(m);
            } else if (category.equals("供应商相关权限")) {
                supplierMenu.add(m);
            }
        }
        map.put("adminMenu", adminMenu);
        map.put("productMenu", productMenu);
        map.put("powerMenu", powerMenu);
        map.put("wareHousingMenu", wareHousingMenu);
        map.put("deliveryMenu", deliveryMenu);
        map.put("supplierMenu", supplierMenu);
        return map;
    }

    @SystemControllerLog(description = "获取角色列表")
    @GetMapping("/api/get/role")
    public HashMap getAllRole() {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Role> allRole = powerAndRolesService.getAllRole();
        map.put("roles", allRole);
        return map;
    }

    @SystemControllerLog(description = "增加角色")
    @PostMapping("/api/post/role")
    public int addRole(String role, String roleZh) {
        return powerAndRolesService.addRole(role, roleZh);
    }

}

