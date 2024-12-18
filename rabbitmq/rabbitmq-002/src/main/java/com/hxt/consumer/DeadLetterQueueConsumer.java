package com.hxt.consumer;

import com.hxt.config.ConfirmConfig;
import com.hxt.config.DelayedQueueConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @RabbitListener(queues = "QD")
    public void receiveD(Message message) {
        String msg = new String(message.getBody());
        log.info("time {}, received dead letter message:{}", new Date().toString(),msg);

    }

//    @RabbitListener(queues = "QA")
//    public void receiveA(Message message, Channel channel) {
//        String msg = new String(message.getBody());
//        log.info("time {}, received dead letter message:{}", new Date().toString(),msg);
//    }
//
//    @RabbitListener(queues = "QB")
//    public void receiveB(Message message, Channel channel) {
//        String msg = new String(message.getBody());
//        log.info("time {}, received dead letter message:{}", new Date().toString(),msg);
//    }

    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayedQueue(Message message){
        String msg = new String(message.getBody());
        log.info("当前时间：{},收到延时队列的消息：{}", new Date().toString(), msg);
    }

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE)
    public void receiveConfirmMessage(Message message){
        String msg = new String(message.getBody());
        log.info("接受到的队列confirm.queue消息:{}",msg);
    }


}
