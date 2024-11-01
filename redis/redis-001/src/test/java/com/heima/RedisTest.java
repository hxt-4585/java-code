package com.heima;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class RedisTest {
    Jedis jedis;
    @Before
    public void setUp(){
        jedis = new Jedis("192.168.64.131", 6379);
        jedis.auth("20170440");
        jedis.select(0);
    }

    @After
    public void tearDown(){
        if (jedis != null){
            jedis.close();
        }
    }
    @Test
    public void testString(){
        jedis.set("name", "Kyle");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    public void testHash(){
        jedis.hset("heima:user:4", "name", "hxt");
        Map<String, String> stringStringMap = jedis.hgetAll("heima:user:3");
        System.out.println(stringStringMap);
    }
}
