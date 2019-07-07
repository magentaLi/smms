package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.UMenu;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UMenuMapper {

    ArrayList<UMenu> getUMenuById(Integer id);

    ArrayList<UMenu> getAllUMenu();

    int deleteSubMenuByRoleId(int roleId);

    int updateSubMenuForRole(@Param("roleId") int roleId, @Param("subMenuId") int[] subMenuId);

    List<Integer> getSubMenuByRole(Integer id);

}
