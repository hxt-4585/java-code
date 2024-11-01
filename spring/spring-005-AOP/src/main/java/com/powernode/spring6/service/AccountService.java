package com.powernode.spring6.service;

import org.springframework.stereotype.Component;

@Component
public class AccountService {
    public void transfer(){
        System.out.println("正在进行银行账户转账");
    }

    public void withdraw(){
        System.out.println("正在进行取款操作");
    }
}
