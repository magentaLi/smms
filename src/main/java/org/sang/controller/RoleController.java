package org.sang.controller;

import org.sang.bean.ProductCategory;
import org.sang.bean.Role;
import org.sang.logger.SystemControllerLog;
import org.sang.mapper.RoleMapper;
import org.sang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author magentaLi
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;

    @SystemControllerLog(description = "添加角色")
    @PostMapping("/api/post/role")
    public Map addRole(Role role) {
        HashMap<String, Object> map = new HashMap<>();
        int i = roleMapper.countRoleByNameZh(role.getNameZh());
        if (i == 0) {
            roleMapper.addNewRole(role.getName(), role.getNameZh());
            map.put("isOK", true);
            map.put("msg", "添加角色成功");
        } else {
            map.put("isOK", false);
            map.put("msg", "该角色已经存在，请勿重复添加！");
        }
        return map;
    }

    @SystemControllerLog(description = "删除角色")
    @DeleteMapping("/api/delete/role")
    public Map deleteRole(Long rid) {
        HashMap<String, Object> map = new HashMap<>();
        int i = roleMapper.deleteRoleById(rid);
        if (i == 0) {
            map.put("isOK", false);
            map.put("msg", "删除角色失败");
        } else {
            map.put("isOK", true);
            map.put("msg", "删除角色成功");
        }
        return map;
    }

    @SystemControllerLog(description = "修改角色权限")
    @PutMapping("/api/put/roleMenu")
    public Map putRoleMenu(int roleId, String mId) {
        HashMap<String, Object> map = new HashMap<>();
        int i = roleService.updateMenuForRole(roleId, mId);
        map.put("isOK", true);
        map.put("msg", "修改成功");
        return map;
    }

    @SystemControllerLog(description = "查询角色的权限")
    @GetMapping("/api/get/roleMenu/{roleId}")
    public ArrayList getRMenu(@PathVariable("roleId") int roleId) {
        return roleService.getRoleMenu(roleId);
    }

}
