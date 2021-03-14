package com.example.soapproducerdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import spring.soap_producer_demo.Order;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderRepositoryService {

    private static final Map<String, Order> orders = new HashMap<>();

    @PostConstruct
    public void initData() {
        for(int i = 0; i < 5; i ++) {
            Order order = new Order();
            order.setOrderId(i+"L");
            order.setClientId("1L");
            order.setVolume(i*100);
            order.setTicker("IBM");
            order.setPrice(i*3.0);
            orders.put(order.getOrderId(), order);
        }
    }

    public Order findOrder(String id) {
        Assert.notNull(id, "Id must be provided!");
        return orders.get(id);
    }
}
