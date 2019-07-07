package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Warehousing;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface WarehousingMapper {

    int addWarehousing(Warehousing warehousing);

    int deleteWarehousingBydId(Integer warehousingId);

    List<Warehousing> getWarehousing();

    Warehousing getWarehousingById(Integer warehousingId);

    int updateWarehousing(Warehousing warehousing);

    ArrayList<Warehousing> getWarehousings(@Param("index") int index, @Param("size") int size, @Param("warehousingId") String warehousingId, @Param("productCode") String productCode, @Param("supplierCode") String supplierCode);

}
