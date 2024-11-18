package com.hxt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot006ApplicationTests {

    @DisplayName("测试一")
    @Test
    void contextLoads() {
        System.out.println("a");
    }

    @DisplayName("测试二")
    @Test
    void contextLoadsTwo() {
        System.out.println("b");
    }

}
