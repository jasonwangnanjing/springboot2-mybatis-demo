package com.jw.service.user.impl;

import com.jw.dao.OrderDetailDao;
import com.jw.model.OrderDetail;
import com.jw.service.user.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( value = "OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public int createOrderDetail(OrderDetail orderDetail) {

        return  orderDetailDao.createOrderDetail(orderDetail);

    }
}
