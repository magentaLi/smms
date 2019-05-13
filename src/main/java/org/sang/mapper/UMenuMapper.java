package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.UMenu;

import java.util.List;

@Mapper
public interface UMenuMapper {

    List<UMenu> getUMenuById(Integer id);

}
