package com.jw.service.impl;

import com.jw.dao.OrderDao;
import com.jw.model.Order;
import com.jw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public int createOrder(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderDao.getOrder(orderId);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.update(order);
    }
}
