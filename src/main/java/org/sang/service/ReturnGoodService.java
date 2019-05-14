package org.sang.service;

import org.sang.bean.ReturnGood;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface ReturnGoodService {

    int addReturnGood(ReturnGood returnGood);

    ArrayList<ReturnGood> getReturnGood(int index, int size, String productCode, String startDate, String endDate);

}
