package org.sang.service;

import org.sang.bean.UMenu;
import org.sang.mapper.UMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UMenuService {

    @Autowired
    UMenuMapper uMenuMapper;
    //根据userId查询一级二级菜单
    public List<UMenu> getUMenuById(Integer id) {
        List<UMenu> uMenus = uMenuMapper.getUMenuById(id);
        return uMenus;
    }
}
