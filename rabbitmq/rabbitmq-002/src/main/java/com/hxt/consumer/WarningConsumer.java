package com.hxt.consumer;

import com.hxt.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WarningConsumer {
    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE)
    public void confirm(Message message) {
        String msg = new String(message.getBody());
        log.error("报警发现不可路由消息:{}",msg);
    }
}
