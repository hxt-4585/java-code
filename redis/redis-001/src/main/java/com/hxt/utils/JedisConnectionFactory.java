package com.hxt.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private  static JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接
        poolConfig.setMaxTotal(8);
        // 最大空闲连接
        // 在连接池中没有被当前的客户端线程使用，处于等待状态的连接
        poolConfig.setMaxIdle(8);
        // 最小空闲连接
        poolConfig.setMinIdle(0);
        // 设置最长等待时间
        poolConfig.setMaxWaitMillis(1000);

        // 创建连接池对象，参数：连接池配置、ip、端口、超时时间、密码
        jedisPool = new JedisPool(poolConfig, "192.168.116.128", 6379, 1000, "20170440");

    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
