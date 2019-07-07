package org.sang.service;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Warehousing;

import java.util.ArrayList;
import java.util.List;

public interface WarehousingService {
    int addWarehousing(Warehousing warehousing);

    int deleteWarehousingBydId(Integer warehousingId);

    List<Warehousing> getWarehousing();

    Warehousing getWarehousingById(Integer warehousingId);

    int updateWarehousing(Warehousing warehousing);

    ArrayList<Warehousing> getWarehousings(int index, int size, String warehousingId, String productCode, String supplierCode);
}
