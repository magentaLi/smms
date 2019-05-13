package org.sang.service;

import org.sang.bean.Role;
import org.sang.mapper.RoleMapper;
import org.sang.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public ArrayList<Role> getRolesByUId(Integer uId) {
        ArrayList<Role> roles = new ArrayList<>();
        ArrayList<Integer> userRoles = userRoleMapper.getUserRoles(uId);
        for (int r : userRoles) {
            Role role = roleMapper.getRoleByRid(r);
            roles.add(role);
        }
        return roles;
    }

    @Override
    public void updateUserRoles(Integer uId, String roles) {
        userRoleMapper.deleteUserRole(uId);
        String[] split = roles.split(",");
        for (String s : split) {
            int i = Integer.parseInt(s);
            int countUserRole = userRoleMapper.countUserRole(uId, i);
            if (countUserRole == 0) {
                userRoleMapper.insertUserRole(uId, i);
            }
        }
    }
}
