package com.hxt.three;

import com.hxt.utils.RabbitMQUtil;
import com.hxt.utils.SleepUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Work04 {
    //队列名称
    public static final String TASK_QUEUE_NAME = "ACK_QUEUE";

    //接受消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtil.getChannel();
        System.out.println("worker04等待接受消息处理时间较长");

        DeliverCallback deliverCallback =(consumerTag,message) ->{

            //沉睡1S
            SleepUtil.sleep(30);
            System.out.println("接受到的消息:"+new String(message.getBody(),"UTF-8"));
            //手动应答
            /**
             * 1.消息的标记Tag
             * 2.是否批量应答 false表示不批量应答信道中的消息
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);

        };

        CancelCallback cancelCallback = (consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");

        });

        channel.basicQos(5);
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME,autoAck,deliverCallback,cancelCallback);
    }
}
