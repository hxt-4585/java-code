package com.hxt.six;

import com.hxt.utils.RabbitMQUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogsDirect02 {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtil.getChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 声明一个临时队列
        channel.queueDeclare("disk", false, false, false, null);

        // 绑定交换机和队列
        /**
         * 队列名称
         * 交换机名称
         * routingKey
         */
        channel.queueBind("disk", EXCHANGE_NAME, "error");
        System.out.println("等待接收消息，把接收到的消息打印在屏幕上...");

        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println("ReceiveLogsDirect02控制台打印接收到的消息:"+new String(message.getBody(),"UTF-8"));
        };
        channel.basicConsume("disk", true, deliverCallback, consumerTag -> {});
    }
}
