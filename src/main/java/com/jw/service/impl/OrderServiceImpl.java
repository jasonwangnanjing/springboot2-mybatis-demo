package com.jw.service.impl;

import com.jw.dao.OrderDao;
import com.jw.dao.OrderDetailDao;
import com.jw.model.Order;
import com.jw.service.OrderDetailService;
import com.jw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderDetailService orderDetailService;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int createOrder(Order order) {
        int order_created = orderDao.create(order);

        order.getOrderDetails().forEach( item -> item.setOrderId(order.getOrderNumber()));

        int order_detail_Created = orderDetailService.createOrderDetails(order.getOrderDetails());

        if (order_created > 0 && order_detail_Created > 0) {
            return order_created;

        } else {
            //raise exception in future.
            return 0;
        }
    }

    @Override
    public Order getOrder(BigInteger orderId) {
        return orderDao.getOrder(orderId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateOrder(Order order) {


        return orderDao.update(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int deleteOrder(BigInteger order_number) {
        return orderDao.delete(order_number);
    }
}
