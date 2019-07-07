package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.User;
import org.sang.bean.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Long id);

    int userReg(@Param("username") String username, @Param("password") String password);

    List<User> getUsersByKeywords(@Param("keywords") String keywords);

    int updateHr(User user);

    int deleteRoleByHrId(Long userId);

    int addRolesForHr(@Param("userId") Long hrId, @Param("rids") Long[] rids);

    User getHrById(Long userId);

    int deleteHr(Long userId);

    List<User> getAllHr(@Param("currentId") Long currentId);

    ArrayList<User> getUserByNamePhoneUsername(@Param("index") int index, @Param("size") int size, @Param("name") String name, @Param("username") String username, @Param("phone") String phone);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long userId);

    int countUserByUsername(String username);

    User getUserByName(String name);

//    int getUserSize();

}
