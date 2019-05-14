package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.Wastage;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Mapper
public interface WastageMapper {

    ArrayList<Wastage> getAllWastage();

    ArrayList<Wastage> getWastageByProductCode(String productCode);

    int addWastage(Wastage wastage);

}
