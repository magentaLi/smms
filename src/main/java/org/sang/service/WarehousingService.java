package org.sang.service;

import org.sang.bean.Warehousing;

import java.util.List;

public interface WarehousingService {
    int addWarehousing(Warehousing warehousing);

    int deleteWarehousingBydId(Integer warehousingId);

    List<Warehousing> getWarehousing();

    Warehousing getWarehousingById(Integer warehousingId);

    int updateWarehousing(Warehousing warehousing) ;
}
