package org.sang.service;

import org.sang.bean.Supplier;
import org.sang.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    @Override
    public int deleteSupplier(String supplierCode) {
        return supplierMapper.deleteSupplier(supplierCode);
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierMapper.getAllSupplier();
    }

    @Override
    public Supplier getSupplierBySupplierCode(String supplierCode) {
        return supplierMapper.getSupplierBySupplierCode(supplierCode);
    }
}
