package org.sang.controller;

import org.sang.bean.Menu;
import org.sang.bean.Role;
import org.sang.logger.SystemControllerLog;
import org.sang.service.PowerAndRolesService;
import org.sang.service.RoleService;
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

    @Autowired
    RoleService roleService;


    @SystemControllerLog(description = "获取权限列表")
    @GetMapping("/api/get/menu")
    public List getAllPower() {
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
        ArrayList<HashMap<String, Object>> vals = new ArrayList<>();
        HashMap<String, Object> val1 = new HashMap<>();
        val1.put("id", 500);
        val1.put("name", "管理员权限");
        val1.put("children", adminMenu);
        HashMap<String, Object> val2 = new HashMap<>();
        val2.put("id", 501);
        val2.put("name", "商品相关权限");
        val2.put("children", productMenu);
        HashMap<String, Object> val3 = new HashMap<>();
        val3.put("id", 502);
        val3.put("name", "权限相关权限");
        val3.put("children", powerMenu);
        HashMap<String, Object> val4 = new HashMap<>();
        val4.put("id", 503);
        val4.put("name", "入库相关权限");
        val4.put("children", wareHousingMenu);
        HashMap<String, Object> val5 = new HashMap<>();
        val5.put("id", 504);
        val5.put("name", "出库相关权限");
        val5.put("children", deliveryMenu);
        HashMap<String, Object> val6 = new HashMap<>();
        val6.put("id", 505);
        val6.put("name", "供应商相关权限");
        val6.put("children", supplierMenu);
        vals.add(val1);
        vals.add(val2);
        vals.add(val3);
        vals.add(val4);
        vals.add(val5);
        vals.add(val6);
        return vals;
    }

    @SystemControllerLog(description = "分页获取角色列表")
    @GetMapping("/api/get/role")
    public HashMap getRoles(int index, int size, String nameZh) {
        HashMap<Object, Object> map = new HashMap<>();
        List<Role> roles = roleService.getRoles(index, size, nameZh);
        int rolesSize = roleService.getRoles(1, Integer.MAX_VALUE, nameZh).size();
        int pages;
        if (rolesSize <= size) {
            pages = 1;
        } else {
            pages = rolesSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", rolesSize);
        map.put("countOfPage", pages);
        map.put("allRoles", roles);
        return map;
    }

}

