package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.ReturnGood;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Mapper
public interface ReturnGoodMapper {

    int insertReturnGood(ReturnGood returnGood);


    ArrayList<ReturnGood> getReturnGood(@Param("index") int index, @Param("size") int size, @Param("productCode") String productCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

}
