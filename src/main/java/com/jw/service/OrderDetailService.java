package com.jw.service;

import com.jw.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    int createOrderDetail(OrderDetail orderDetail);

    int createOrderDetails(List<OrderDetail> orderDetail);

    List<OrderDetail> getOrderDetails(String order_number);

    OrderDetail getOrderDetail(String orderId,String itemId);

    int updateOrderDetail(OrderDetail orderDetail);

    int deleteOrderDetail(OrderDetail orderDetail);
}
