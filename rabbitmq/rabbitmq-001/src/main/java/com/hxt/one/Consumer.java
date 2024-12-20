package com.hxt.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    //队列的名称
    public static final String QUEUE_NAME="mirror_hello";
    // 接受消息
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.116.131");
        factory.setUsername("admin");
        factory.setPassword("20170440");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        };

        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        /**
         * 消费者消息信息
         * 1、消费哪个队列
         * 2、消费成功后是否要自动应答true，代表自动应答   false：代表手动应答
         * 3、消费者成功消费的回调
         * 4、消费者未成功消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
