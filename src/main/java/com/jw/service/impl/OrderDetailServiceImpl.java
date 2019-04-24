package com.jw.service.impl;

import com.jw.dao.OrderDetailDao;
import com.jw.model.OrderDetail;
import com.jw.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public int createOrderDetail(OrderDetail orderDetail) {

        return orderDetailDao.createOrderDetail(orderDetail);

    }

    @Override
    public List<OrderDetail> getOrderDetails(String orderId) {
        return orderDetailDao.getOrderDetails(orderId);
    }

    @Override
    public OrderDetail getOrderDetail(String orderId, String itemId) {
        return orderDetailDao.getOrderDetail(orderId,itemId);
    }


}
