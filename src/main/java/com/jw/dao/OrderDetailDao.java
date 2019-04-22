package com.jw.dao;

import com.jw.model.Order;
import com.jw.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao {

    int createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getOrderDetails(String order_number);
    int updateOrderDetail(OrderDetail orderDetail);
    int deleteOrderDetail(OrderDetail orderDetail);
}
