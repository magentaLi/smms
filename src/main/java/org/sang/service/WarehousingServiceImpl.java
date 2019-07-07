package org.sang.service;

import org.sang.bean.Warehousing;
import org.sang.mapper.WarehousingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    WarehousingMapper warehousingMapper;

    @Override
    public int addWarehousing(Warehousing warehousing) {
        return warehousingMapper.addWarehousing(warehousing);
    }

    @Override
//    @CacheEvict(value = "warehousing")
    public int deleteWarehousingBydId(Integer warehousingId) {
        return warehousingMapper.deleteWarehousingBydId(warehousingId);
    }

    @Override
//    @Cacheable(value = "warehousings", unless = "#result == null")
    public List<Warehousing> getWarehousing() {
        return warehousingMapper.getWarehousing();
    }

    @Override
//    @Cacheable(value = "warehousing", unless = "#result == null")
    public Warehousing getWarehousingById(Integer warehousingId) {
        return warehousingMapper.getWarehousingById(warehousingId);
    }

    @Override
//    @CachePut(value = "warehousing")
    public int updateWarehousing(Warehousing warehousing) {
        return warehousingMapper.updateWarehousing(warehousing);
    }

    @Override
    public ArrayList<Warehousing> getWarehousings(int index, int size, String warehousingId, String productCode, String supplierCode) {
        int currentPage = (index - 1) * size;
        return warehousingMapper.getWarehousings(currentPage, size, warehousingId, productCode, supplierCode);
    }
}
