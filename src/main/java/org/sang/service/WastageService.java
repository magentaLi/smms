package org.sang.service;

import org.sang.bean.Wastage;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface WastageService {

    ArrayList<Wastage> getWastageByProductCode(String productCode);

    int addWastage(Wastage wastage);

    ArrayList<Wastage> getWastages(int index, int size, String productName, String productCode);
    
}
