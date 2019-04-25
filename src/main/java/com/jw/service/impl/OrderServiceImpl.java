package com.jw.service.impl;

import com.jw.dao.OrderDao;
import com.jw.model.Order;
import com.jw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service(value = "OrderService")
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

    @Override
    public int deleteOrder(BigInteger order_number) {
        return orderDao.delete(order_number);
    }
}
