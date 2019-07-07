package org.sang.service;

import org.sang.bean.Menu;
import org.sang.bean.Role;
import org.sang.mapper.MenuMapper;
import org.sang.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author magentaLi
 */
@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class PowerAndRolesServiceImpl implements PowerAndRolesService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
//    @Cacheable(value = "menus", unless = "#result == null")
    public ArrayList<Menu> getAllMenu() {
        List<Menu> allMenus = menuMapper.getAllMenu();
        ArrayList<Menu> allMenu = new ArrayList<>(allMenus);
        return allMenu;
    }

    @Override
//    @Cacheable(value = "roles", unless = "#result == null")
    public ArrayList<Role> getAllRole() {
        ArrayList<Role> roles = roleMapper.getAllRoles();
        return roles;
    }

    @Override
    public int addRole(String role, String roleZh) {
        int i = roleMapper.addNewRole(role, roleZh);
        return i;
    }
}
