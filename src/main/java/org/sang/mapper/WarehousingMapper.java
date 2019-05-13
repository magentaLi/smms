package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.Warehousing;

import java.util.List;

@Mapper
public interface WarehousingMapper {

    int addWarehousing(Warehousing warehousing);

    int deleteWarehousingBydId(Integer warehousingId);

    List<Warehousing> getWarehousing();

    Warehousing getWarehousingById(Integer warehousingId);

    int updateWarehousing(Warehousing warehousing);


}
