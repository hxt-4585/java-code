package com.powernode;

import com.powernode.spring6.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testTransactionAOP(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        orderService.generate();
        orderService.cancel();

        accountService.transfer();
        accountService.withdraw();
    }

    @Test
    public void testSecurity(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        userService.getUser();
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        productService.getProduct();
        productService.saveProduct();
        productService.deleteProduct();
        productService.modifyProduct();
    }
}
