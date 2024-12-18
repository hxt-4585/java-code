package com.hxt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    // 当Spring容器完成Bean的装配（包括属性注入和依赖注入）后，它会寻找所有带有@PostConstruct注解的方法，并按声明的顺序执行它们。
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }
    /**
     * 交换机确认回调方法
     * 1.发消息 交换机收到了  回调
     *  1.1 correlationData 保存回调消息的ID及相关信息
     *  1.2 交换机收到消息 ack=true
     *  1.3 cause null
     * 2.发消息  交换机接收失败了  回调
     *  2.1 correlationData 保存回调消息的ID及相关信息
     *  2.2 交换机收到消息  ack=false
     *  2.3 cause失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack){
            log.info("交换机已经收到ID为{}的消息", id);
        }else {
            log.info("交换机还未收到ID为:{}的消息，由于原因:{}",id,cause);
        }
    }

    // 可以当消息在传递过程中不可达目的地时将消息返回给生产者
    // 只有不可达目的时 才进行回退

    /**
     * 当消息无法路由的时候回调
     * message      消息
     * replyCode    编码
     * replyText    退回原因
     * exchange     从哪个交换机退回
     * routingKey   通过哪个路由 key 退回
     */

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.error("消息{}，被交换机{}返回，退回原因：{}，路由key：{}", returned.getMessage(), returned.getExchange(), returned.getReplyText(),returned.getRoutingKey());
    }
}
