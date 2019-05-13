package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Product;
import org.sang.bean.Supplier;

import java.util.List;

/**
 * @author magentaLi
 */

@Mapper
public interface SupplierMapper {
    //添加供应商
    int addSupplier(Supplier supplier);

    //删除供应商
    int deleteSupplier(@Param("supplierCode") String supplierCode);

    //修改供应商
    int updateSupplier(Supplier supplier);

    //查询所有供应商
    List<Supplier> getAllSupplier();

    //查询单个供应商
    Supplier getSupplierBySupplierCode(@Param("supplierCode") String supplierCode);
}
