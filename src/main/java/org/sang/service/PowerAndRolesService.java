package org.sang.service;


import org.sang.bean.Menu;
import org.sang.bean.Role;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface PowerAndRolesService {

    ArrayList<Menu> getAllMenu();

    ArrayList<Role> getAllRole();

    int addRole(String role, String roleZh);

}
