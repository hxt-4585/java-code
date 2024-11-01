package com.powernode;

import com.powernode.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void transfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act001", "act002", 20000.0);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
