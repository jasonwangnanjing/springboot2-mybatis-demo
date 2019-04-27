package com.jw.controller;

import com.jw.model.Order;
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

    @ResponseBody
    @PostMapping(value = "/create")
    public int create(@RequestBody Order order){

        return orderService.createOrder(order);
    }

    @ResponseBody
    @PatchMapping(value = "/update")
    public int update(@RequestBody Order order){

        return orderService.updateOrder(order);
    }


    @ResponseBody
    @GetMapping(value = "/get/{order_number}")
    public Order get(@PathVariable("order_number") String  order_number){

        return orderService.getOrder(order_number);
    }




}
