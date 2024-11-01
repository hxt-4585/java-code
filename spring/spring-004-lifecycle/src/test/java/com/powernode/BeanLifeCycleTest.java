package com.powernode;

import com.powernode.spring6.bean.Husband;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
    @Test
    public void testBeanFifeCycleBy5(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步、使用Bean");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testBeanFifeCycleBy7(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步、使用Bean");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testBeanFifeCycleBy10(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第八步、使用Bean");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testBeanRegister(){
        User user = new User();
        System.out.println(user);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("userBean", user);
        User userBean = factory.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testCircularDependency(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-circular-dependencies.xml");
        Husband husband = context.getBean("husband", Husband.class);
        Wife wife = context.getBean("wife", Wife.class);
        System.out.println(husband);
        System.out.println(wife);
    }
}
