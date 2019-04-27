package com.jw.service.impl;

import com.jw.dao.OrderDetailDao;
import com.jw.model.OrderDetail;
import com.jw.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int createOrderDetail(OrderDetail orderDetail) {

        return orderDetailDao.createOrderDetail(orderDetail);

    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int createOrderDetails(List<OrderDetail> orderDetails) {

        return orderDetailDao.createOrderDetails(orderDetails);
    }

    @Override
    public List<OrderDetail> getOrderDetails(String order_number) {
        return orderDetailDao.getOrderDetails(order_number);
    }

    @Override
    public OrderDetail getOrderDetail(String orderId, String itemId) {
        return orderDetailDao.getOrderDetail(orderId, itemId);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        System.out.println(orderDetail);
        return orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    public int deleteOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.deleteOrderDetail(orderDetail);
    }


}
