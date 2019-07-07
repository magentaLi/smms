package org.sang.service;

import org.sang.bean.ReturnGood;
import org.sang.mapper.ReturnGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author magentaLi
 */
@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class ReturnGoodServiceImpl implements ReturnGoodService {

    @Autowired
    ReturnGoodMapper returnGoodMapper;

    @Override
    public int addReturnGood(ReturnGood returnGood) {
        returnGood.setReturnDate(new Date());
        return returnGoodMapper.insertReturnGood(returnGood);
    }

    @Override
//    @Cacheable(value = "returnGoods", unless = "#result == null")
    public ArrayList<ReturnGood> getReturnGood(int index, int size, String productCode, String startDate, String endDate) {
        int currentPage = (index - 1) * size;
        return returnGoodMapper.getReturnGood(currentPage, size, productCode, startDate, endDate);
    }

}
