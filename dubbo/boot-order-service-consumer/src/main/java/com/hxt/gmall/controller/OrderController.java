package com.hxt.gmall.controller;

import com.hxt.gmall.bean.UserAddress;
import com.hxt.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @GetMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid")String userId){
        return orderService.initOrder(userId);
    }
}
