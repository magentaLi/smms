package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Delivery;
import org.sang.bean.Warehousing;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DeliveryMapper {

    int addDelivery(Delivery delivery);

    int deleteDeliveryBydId(Integer deliveryId);

    List<Delivery> getDelivery();

    Delivery getDeliveryById(Integer deliveryId);

    int updateDelivery(Delivery delivery);

    ArrayList<Delivery> getDeliverys(@Param("index") int index, @Param("size") int size, @Param("deliveryId") String deliveryId, @Param("productCode") String productCode);


}
