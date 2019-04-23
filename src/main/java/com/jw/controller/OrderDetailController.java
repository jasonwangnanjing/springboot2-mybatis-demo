package com.jw.controller;

import com.jw.model.OrderDetail;
import com.jw.service.user.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/OrderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @ResponseBody
    @PostMapping(value = "/add")
    public int add(@RequestBody OrderDetail orderDetail){

        return orderDetailService.createOrderDetail(orderDetail);

    }
}
