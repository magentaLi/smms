package org.sang.service;

import org.sang.bean.Delivery;
import org.sang.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public int addDelivery(Delivery delivery) {
        return deliveryMapper.addDelivery(delivery);
    }

    @Override
    public int deleteDeliveryBydId(Integer deliveryId) {
        return deliveryMapper.deleteDeliveryBydId(deliveryId);
    }

    @Override
    public List<Delivery> getDelivery() {
        return deliveryMapper.getDelivery();
    }

    @Override
    public Delivery getDeliveryById(Integer deliveryId) {
        return deliveryMapper.getDeliveryById(deliveryId);
    }

    @Override
    public int updateDelivery(Delivery delivery) {
        return deliveryMapper.updateDelivery(delivery);
    }
}
