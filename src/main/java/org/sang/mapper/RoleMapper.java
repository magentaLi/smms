package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2018/1/1.
 */
@Mapper
public interface RoleMapper {
    List<Role> roles();

    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);

    int deleteRoleById(Long rid);

    ArrayList<Role> getAllRoles();

    Role getRoleByRid(@Param("rId") int rId);

    ArrayList<Role> getRoles(@Param("index") int index, @Param("size") int size, @Param("nameZh") String nameZh);

    int countRoleByNameZh(String nameZh);

    //角色的权限相关

    ArrayList<Integer> getRoleMenu(@Param("rid") int rid);

    int deleteRoleMenu(int rid);

    int updateMenuForRole(@Param("rid") int rid, @Param("mid") int[] mid);
}
