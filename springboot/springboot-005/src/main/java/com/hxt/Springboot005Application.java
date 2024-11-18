package com.hxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.hxt.mapper")
@SpringBootApplication
public class Springboot005Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot005Application.class, args);
    }

}
