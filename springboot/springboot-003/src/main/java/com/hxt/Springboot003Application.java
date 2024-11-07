package com.hxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot003Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Springboot003Application.class, args);
    }

}
