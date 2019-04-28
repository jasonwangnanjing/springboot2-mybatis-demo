package com.jw.service.impl;

import com.jw.dao.OrderDetailDao;
import com.jw.model.OrderDetail;
import com.jw.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public int createOrderDetail(OrderDetail orderDetail) {

        return orderDetailDao.createOrderDetail(orderDetail);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    //item could be created together with order, or created with exist order.
    //user REQUIRED, to combine with order creation, or own creation.
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public int updateOrderDetail(OrderDetail orderDetail) {

        return orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public int updateOrderDetails(List<OrderDetail> orderDetails) {

        return orderDetailDao.updateOrderDetails(orderDetails);
    }

    @Override
    public int deleteOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.deleteOrderDetail(orderDetail);
    }


}
