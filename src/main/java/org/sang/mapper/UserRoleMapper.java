package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @author magentaLi
 */

@Mapper
public interface UserRoleMapper {

    int countUserRole(@Param("uId") int uId, @Param("rId") int rId);

    ArrayList<Integer> getUserRoles(@Param("uId") int uId);

    int insertUserRole(@Param("uId") int uId, @Param("rId") int rId);

    int deleteUserRole(@Param("uId") int uId);

}
