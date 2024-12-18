package com.hxt.four;

import com.hxt.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 发布确认模式：
 *  1、单个确认
 *  2、批量确认
 *  3、异步批量确认
 */
public class ConfirmMessage {

    public static final int MESSAGE_COUNT = 1000;


    public static void main(String[] args) throws Exception {
        ConfirmMessage.publishMessageAsync();
    }

    public static void publishMessageIndividually() throws Exception{
        Channel channel = RabbitMQUtil.getChannel();
        // 队列声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);

        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个消息就马上进行发布确认
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("发消息成功");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"个单独确认消息，耗时:"+(end-begin)+"ms");
    }

    public static void publishMessageBatch() throws Exception{
        Channel channel = RabbitMQUtil.getChannel();
        // 队列声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);

        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量确认消息的大小
        int batchSize = 100;

        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 批量确认
            if( ( i + 1 ) % batchSize == 0 ){
                //发布确认
                boolean flag = channel.waitForConfirms();
                if (flag) {
                    System.out.println("发消息成功");
                }
            }

        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT / batchSize+"个批量确认消息，耗时:"+(end-begin)+"ms");
    }

    public static void publishMessageAsync() throws Exception{
        Channel channel = RabbitMQUtil.getChannel();
        // 队列声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);

        // 开启发布确认
        channel.confirmSelect();
        /**
         * 线程安全有序的哈希表 适用于高并发场景
         *  1、轻松地将序号与消息进行关联
         *  2、轻松删除批量条目
         *  3、支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();

        // 开始时间
        long begin = System.currentTimeMillis();

        //消息确认回调的函数
        ConfirmCallback ackCallback = (deliveryTag, multiple) ->{
            // 删除已确认的消息
            // 如果是批量删除
            if (multiple){
                ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            }else {
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息:" + deliveryTag);
        };
        ConfirmCallback nackCallback= (deliveryTag,multiple) ->{
            //3.打印一下未确认的消息都有哪些
            String message = outstandingConfirms.remove(deliveryTag);
            System.out.println("未确认的消息是:"+message+":::未确认的消息tag:"+deliveryTag);
        };
        channel.addConfirmListener(ackCallback,nackCallback);//异步通知


        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
        }

        long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"个异步发布确认消息，耗时:"+(end-begin)+"ms");

    }

}
