package com.jw.service;

import com.jw.model.Order;

import java.math.BigInteger;

public interface OrderService {


    int createOrder(Order order);


    Order getOrder(String orderId);

    int updateOrder(Order order);

    int deleteOrder(BigInteger order_number);
}
