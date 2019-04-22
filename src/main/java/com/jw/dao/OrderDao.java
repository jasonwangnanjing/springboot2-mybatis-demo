package com.jw.dao;

import com.jw.model.Order;

import java.util.List;

public interface OrderDao {

    int create(Order order);
    List<Order> getList(int user_id);
    int update(Order order);
    int delete(Order order);
}
