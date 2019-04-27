package com.jw.dao;

import com.jw.model.Order;
import com.jw.model.OrderDetail;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface OrderDetailDao {

    int createOrderDetail(OrderDetail orderDetail);
    int createOrderDetails(List<OrderDetail> orderDetails );
    List<OrderDetail> getOrderDetails(String order_number);
    OrderDetail getOrderDetail(String orderId,String itemId);
    int updateOrderDetail(OrderDetail orderDetail);
    int deleteOrderDetail(OrderDetail orderDetail);
}
