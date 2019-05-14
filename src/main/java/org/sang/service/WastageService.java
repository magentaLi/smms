package org.sang.service;

import org.sang.bean.Wastage;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface WastageService {

    ArrayList<Wastage> getAllWastage();

    ArrayList<Wastage> getWastageByProductCode(String productCode);

    int addWastage(Wastage wastage);

}
