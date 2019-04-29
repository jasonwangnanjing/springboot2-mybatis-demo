package com.jw.dao;

import com.jw.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
@Mapper
@Component
public interface OrderDao {

    int create(Order order);
    Order getOrder(BigInteger orderId);
    int update(Order order);
    int delete(BigInteger order_number);
}
