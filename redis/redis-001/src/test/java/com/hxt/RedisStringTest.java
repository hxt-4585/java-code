package com.hxt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisStringTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("name", "zhangsan");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSaveUser() throws JsonProcessingException {
        User user = new User(10, "hxt");
        // 手动序列化
        String json = objectMapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user", json);
        String userString = stringRedisTemplate.opsForValue().get("user");
        // 手动反序列化
        User readValue = objectMapper.readValue(userString, User.class);
        System.out.println(readValue);
    }
}
