package org.sang.service;

import org.sang.bean.ReturnGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author magentaLi
 */
@Service
public class ReturnGoodServiceImpl implements ReturnGoodService {

    @Autowired
    ReturnGoodService returnGoodService;

    @Override
    public int addReturnGood(ReturnGood returnGood) {
        returnGood.setReturnDate(new Date());
        return returnGoodService.addReturnGood(returnGood);
    }

    @Override
    public ArrayList<ReturnGood> getReturnGood(int index, int size, String productCode, String startDate, String endDate) {
        int currentPage = (index - 1) * size;
        return returnGoodService.getReturnGood(currentPage, size, productCode, startDate, endDate);
    }

}
