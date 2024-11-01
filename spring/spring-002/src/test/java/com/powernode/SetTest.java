package com.powernode;

import com.powernode.spring.pojo.Customer;
import com.powernode.spring.pojo.SimpleType;
import com.powernode.spring.pojo.Student;
import com.powernode.spring.pojo.User;
import com.powernode.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {

    @Test
    public void testExternalInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);
        userService.save();
    }

    @Test
    public void testInternalInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);
        userService.save();
    }

    @Test
    public void testSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SimpleType simpleType = applicationContext.getBean("simpleType", SimpleType.class);
        System.out.println(simpleType);
    }

    @Test
    public void testCascadingAttributeAssignments(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testArrayInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testListInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testMapInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testPropertiesInjection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Customer customer1 = applicationContext.getBean("customer", Customer.class);
        System.out.println(customer1);
        Customer customer2 = applicationContext.getBean("customer", Customer.class);
        System.out.println(customer2);
    }

    @Test
    public void testInstantiation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-instantiation.xml");
        Customer customer = applicationContext.getBean("customer", Customer.class);

    }
}
