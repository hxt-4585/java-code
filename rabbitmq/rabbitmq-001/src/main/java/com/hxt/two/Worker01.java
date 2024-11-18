package com.hxt.two;

import com.hxt.utils.RabbitMQUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 这是一个工作线程，相当于之间的Consumer
 */
public class Worker01 {
    // 队列名称
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtil.getChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody()));
        };

        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };
        /**
         * 消费者消息信息
         * 1、消费哪个队列
         * 2、消费成功后是否要自动应答true，代表自动应答   false：代表手动应答
         * 3、消费者未成功消费的回调
         * 4、消费者取消消费的回调
         */

        System.out.println("C2等待接收消息......");
        // 消息的接受
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
