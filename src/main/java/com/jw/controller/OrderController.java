package com.jw.controller;

import com.jw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @DeleteMapping(value = "/delete/{order_number}")
    public int deleteOrder(@PathVariable("order_number") BigInteger order_number){

        return orderService.deleteOrder(order_number);


    }

}
