package org.sang.service;

import org.sang.bean.Menu;
import org.sang.bean.UMenu;
import org.sang.mapper.UMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UMenuService {

    @Autowired
    UMenuMapper uMenuMapper;

    //根据userId查询一级二级菜单
    public List<UMenu> getUMenuById(Integer id) {
        return uMenuMapper.getUMenuById(id);
    }

    public ArrayList<UMenu> getAllUMenu() {
        return uMenuMapper.getAllUMenu();
    }

    public int updateSubMenuForRole(int roleId, String subMenuId) {
        uMenuMapper.deleteSubMenuByRoleId(roleId);
        String[] split = subMenuId.split(",");
        int[] data = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            data[i] = Integer.parseInt(split[i]);
        }
        int i = uMenuMapper.updateSubMenuForRole(roleId, data);
        return i;
    }

    public List<Integer> getSubMenuByRole(Integer id) {
        return uMenuMapper.getSubMenuByRole(id);
    }

}
