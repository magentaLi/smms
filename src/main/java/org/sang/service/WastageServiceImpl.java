package org.sang.service;

import org.sang.bean.Wastage;
import org.sang.mapper.WastageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class WastageServiceImpl implements WastageService {
    @Autowired
    WastageMapper wastageMapper;

//    @Override
//    @Cacheable(value = "wastages", unless = "#result == null")
//    public ArrayList<Wastage> getAllWastage() {
//        return wastageMapper.getAllWastage();
//    }


    @Override
//    @Cacheable(value = "wastages", unless = "#result == null")
    public ArrayList<Wastage> getWastageByProductCode(String productCode) {
        return wastageMapper.getWastageByProductCode(productCode);
    }

    @Override
    public int addWastage(Wastage wastage) {
        return wastageMapper.addWastage(wastage);
    }

    @Override
    public ArrayList<Wastage> getWastages(int index, int size, String productName, String productCode) {
        int currentPage = (index - 1) * size;
        ArrayList<Wastage> wastages = wastageMapper.getWastages(currentPage, size, productName, productCode);
        return wastages;
    }
}
