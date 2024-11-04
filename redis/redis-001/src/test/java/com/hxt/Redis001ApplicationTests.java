package com.hxt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;

@SpringBootTest
class Redis001ApplicationTests {

    Jedis jedis = null;

    @BeforeEach
    void setUp(){
        jedis = new Jedis("192.168.116.128", 6379);
        jedis.auth("20170440");
        jedis.select(0);
    }

    @Test
    void testString(){
        jedis.set("name", "Kyle");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash(){
        jedis.hset("reggie:user:1","name","Jack");
        jedis.hset("reggie:user:2","name","Rose");
        jedis.hset("reggie:user:1","age","21");
        jedis.hset("reggie:user:2","age","18");
        Map<String, String> map = jedis.hgetAll("reggie:user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown(){
        if (jedis != null){
            jedis.close();
        }
    }
}
