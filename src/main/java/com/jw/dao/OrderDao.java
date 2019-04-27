package com.jw.dao;

import com.jw.model.Order;

import java.math.BigInteger;

public interface OrderDao {

    int create(Order order);
    Order getOrder(BigInteger orderId);
    int update(Order order);
    int delete(BigInteger order_number);
}
