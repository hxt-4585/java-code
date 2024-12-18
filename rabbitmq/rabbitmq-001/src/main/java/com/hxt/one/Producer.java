package com.hxt.one;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    // 队列名称
    public static final String QUEUE_NAME = "mirror_hello";
    public static final String FED_EXCHANGE = "fed_exchange";

    // 发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 工厂ip 连接rabbitmq队列
        String host = "192.168.116.130";
        factory.setHost(host);

        // 用户名
        factory.setUsername("admin");
        // 密码
        factory.setPassword("20170440");

        // 创建连接
        Connection connection = factory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(FED_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.queueDeclare("node2_queue", true, false, false, null);
        channel.queueBind("node2_queue", FED_EXCHANGE, "routingKey");


        /**
         * 生产一个队列
         * 1、队列名称
         * 2、队列里面的消息是否持久化，默认情况下，消息存储在内存中
         * 3、该队列是否只提供一个消费者进行消费，是否进行消息共享，false可以多个
         * 4、是否自动删除，最后一个消费者端断开后，该队列是否自动删除，true自动删除
         * 5、其他参数
         */
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        // 发消息
//        String message = "Hello World!";
//        /**
//         * 发送一个消息
//         * 1、发送到哪个交换机
//         * 2、路由的key值是哪个，本次是队列的名称
//         * 3、其他参数信息
//         * 4、发生消息的消息体
//         */
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        System.out.println("消息发生完成");
    }
}
