package com.powernode.spring6.service;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    public void generate(){
        System.out.println("订单生成");
    }
    public void cancel(){
        System.out.println("取消订单");
    }
}
