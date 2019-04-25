package com.jw.controller;

import com.jw.model.OrderDetail;
import com.jw.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/OrderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @ResponseBody
    @PostMapping(value = "/add")
    public int add(@RequestBody OrderDetail orderDetail) {

        return orderDetailService.createOrderDetail(orderDetail);

    }

    @ResponseBody
    @RequestMapping(value = "/getOrderDetails")
    public List<OrderDetail> get(@RequestParam final String orderId) {

        return orderDetailService.getOrderDetails(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderDetail")
    public OrderDetail get(@RequestParam final String orderId,@RequestParam final String itemId) {

        return orderDetailService.getOrderDetail(orderId,itemId);
    }

    //put change whole object
    @ResponseBody
    @RequestMapping(value = "/updateWholeOrderDetail", method = RequestMethod.PUT)
    public int update(@RequestBody OrderDetail orderDetail){


        return orderDetailService.updateOrderDetail(orderDetail);
    }
    //patch only change part of the object
    @ResponseBody
    @PatchMapping(value = "/updateOrderDetailFields")
    public int updateOrderDetail(@RequestBody OrderDetail orderDetail){

        return orderDetailService.updateOrderDetail(orderDetail);
    }

}
