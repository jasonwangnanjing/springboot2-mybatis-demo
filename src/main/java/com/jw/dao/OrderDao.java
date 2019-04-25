package com.jw.dao;

import com.jw.model.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDao {

    int create(Order order);
    Order getOrder(String orderId);
    int update(Order order);
    int delete(BigInteger order_number);
}
