package com.powernode;

import com.powernode.spring6.service.UserService;
import com.powernode.spring6.service.impl.UserServiceImpl;
import com.powernode.spring6.test.SimpleType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void testBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
    }

    @Test
    public void testSetDIP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }

    @Test
    public void testSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SimpleType simpleType = applicationContext.getBean("simpleType", SimpleType.class);
        System.out.println(simpleType);

    }
}
