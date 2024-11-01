package com.powernode.spring.bean;

import com.powernode.spring.pojo.Customer;

public class VipFactory {
    public static Customer get(){
        return new Customer();
    }
}
