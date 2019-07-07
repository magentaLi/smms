package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Wastage;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Mapper
public interface WastageMapper {
    //名称 编号 类别
    ArrayList<Wastage> getWastages(@Param("index") int index, @Param("size") int size, @Param("productName") String productName, @Param("productCode") String productCode);

    ArrayList<Wastage> getWastageByProductCode(String productCode);

    int addWastage(Wastage wastage);

}
