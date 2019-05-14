package org.sang.service;

import org.sang.bean.Wastage;
import org.sang.mapper.WastageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
@Service
public class WastageServiceImpl implements WastageService {
    @Autowired
    WastageMapper wastageMapper;

    @Override
    public ArrayList<Wastage> getAllWastage() {
        return wastageMapper.getAllWastage();
    }

    @Override
    public ArrayList<Wastage> getWastageByProductCode(String productCode) {
        return wastageMapper.getWastageByProductCode(productCode);
    }

    @Override
    public int addWastage(Wastage wastage) {
        return wastageMapper.addWastage(wastage);
    }
}
