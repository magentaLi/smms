package org.sang.service;

import org.sang.bean.Supplier;
import org.sang.mapper.SupplierMapper;
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
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    @Override
//    @CacheEvict(value = "supplier")
    public int deleteSupplier(String supplierCode) {
        return supplierMapper.deleteSupplier(supplierCode);
    }

    @Override
//    @CachePut(value = "supplier")
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }

    @Override
//    @Cacheable(value = "suppliers", unless = "#result == null")
    public List<Supplier> getAllSupplier() {
        return supplierMapper.getAllSupplier();
    }

    @Override
//    @Cacheable(value = "supplier", unless = "#result == null")
    public Supplier getSupplierBySupplierCode(String supplierCode) {
        return supplierMapper.getSupplierBySupplierCode(supplierCode);
    }

    @Override
    public ArrayList<Supplier> getSuppliers(int index, int size, String supplierName, String supplierReputation) {
        return supplierMapper.getSuppliers((index - 1) * size, size, supplierName, supplierReputation);
    }
}
