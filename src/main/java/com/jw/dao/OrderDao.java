package com.jw.dao;

import com.jw.model.Order;

import java.util.List;

public interface OrderDao {

    int create(Order order);
    Order getOrder(String orderId);
    int update(Order order);
    int delete(Order order);
}
