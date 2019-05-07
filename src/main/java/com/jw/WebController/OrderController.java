package com.jw.WebController;


import com.jw.model.Order;
import com.jw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getAll/{userName}")
    public ModelAndView getOrders(@PathVariable String userName, ModelMap model){


//        List<Order> orderList = sysUserService.getUserOrders();

//        model.addAttribute("orders",orderList);

        return new ModelAndView("order/list");

    }
}
