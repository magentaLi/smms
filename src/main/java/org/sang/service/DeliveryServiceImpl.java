package org.sang.service;

import org.sang.bean.Delivery;
import org.sang.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public int addDelivery(Delivery delivery) {
        delivery.setDeliveryDate(new Date());
        return deliveryMapper.addDelivery(delivery);
    }

    @Override
//    @CacheEvict(value = "delivery")
    public int deleteDeliveryBydId(Integer deliveryId) {
        return deliveryMapper.deleteDeliveryBydId(deliveryId);
    }

    @Override
//    @Cacheable(value = "deliverys", unless = "#result == null")
    public List<Delivery> getDelivery() {
        return deliveryMapper.getDelivery();
    }

    @Override
//    @Cacheable(value = "delivery", unless = "#result == null")
    public Delivery getDeliveryById(Integer deliveryId) {
        return deliveryMapper.getDeliveryById(deliveryId);
    }

    @Override
//    @CachePut(value = "delivery")
    public int updateDelivery(Delivery delivery) {
        return deliveryMapper.updateDelivery(delivery);
    }

    @Override
    public ArrayList<Delivery> getDeliverys(int index, int size, String deliveryId, String productCode) {
        int currentPage = (index - 1) * size;
        ArrayList<Delivery> deliverys = deliveryMapper.getDeliverys(currentPage, size, deliveryId, productCode);
        return deliverys;
    }
}
