package org.sang.service;

import org.sang.bean.Role;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface UserRoleService {

    ArrayList<Role> getRolesByUId(Integer uId);

    void updateUserRoles(Integer uId, String roles);

}
