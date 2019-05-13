package org.sang.service;

import org.sang.bean.Delivery;

import java.util.List;

public interface DeliveryService {
    int addDelivery(Delivery delivery);

    int deleteDeliveryBydId(Integer deliveryId);

    List<Delivery> getDelivery();

    Delivery getDeliveryById(Integer deliveryId);

    int updateDelivery(Delivery delivery);
}
