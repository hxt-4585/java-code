package com.hxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:applicationContext-spring.xml")
public class Springboot002Application {

	public static void main(String[] args) {
		var ioc = SpringApplication.run(Springboot002Application.class, args);

		//1、获取容器中所有组件的名字
		String[] names = ioc.getBeanDefinitionNames();
		//2、挨个遍历：
		// dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
		// SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
		System.out.println(ioc.getBean("teacher").toString());
	}

}
