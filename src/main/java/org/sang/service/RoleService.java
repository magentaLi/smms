package org.sang.service;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2018/1/1.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> roles() {
        return roleMapper.roles();
    }

    public int addNewRole(String role, String roleZh) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        return roleMapper.addNewRole(role, roleZh);
    }

    public int deleteRoleById(Long rid) {
        return roleMapper.deleteRoleById(rid);
    }

    @Cacheable(value = "roles", unless = "#result == null")
    public ArrayList<Role> getRoles(int index, int size, String nameZh) {
        int currentPage = (index - 1) * size;
        ArrayList<Role> roles = roleMapper.getRoles(currentPage, size, nameZh);
        return roles;
    }

    public int updateMenuForRole(int rid, String mid) {
        roleMapper.deleteRoleMenu(rid);
        String[] split = mid.split(",");
        int[] data = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            data[i] = Integer.parseInt(split[i]);
        }
        int i = roleMapper.updateMenuForRole(rid, data);
        return i;
    }

    public ArrayList<Integer> getRoleMenu(int rId) {
        ArrayList<Integer> roleMenu = roleMapper.getRoleMenu(rId);
        return roleMenu;
    }

}
