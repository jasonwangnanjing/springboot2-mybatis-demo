package com.jw.service;

import com.jw.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    int createOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetails(String order_number);

    OrderDetail getOrderDetail(String orderId,String itemId);
}