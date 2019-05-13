package org.sang.service;

import org.sang.bean.Warehousing;
import org.sang.mapper.WarehousingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    WarehousingMapper warehousingMapper;

    @Override
    public int addWarehousing(Warehousing warehousing) {
        return warehousingMapper.addWarehousing(warehousing);
    }

    @Override
    public int deleteWarehousingBydId(Integer warehousingId) {
        return warehousingMapper.deleteWarehousingBydId(warehousingId);
    }

    @Override
    public List<Warehousing> getWarehousing() {
        return warehousingMapper.getWarehousing();
    }

    @Override
    public Warehousing getWarehousingById(Integer warehousingId) {
        return warehousingMapper.getWarehousingById(warehousingId);
    }

    @Override
    public int updateWarehousing(Warehousing warehousing) {
        return warehousingMapper.updateWarehousing(warehousing);
    }
}
