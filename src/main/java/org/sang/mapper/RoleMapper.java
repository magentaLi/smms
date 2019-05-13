package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;

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
}
