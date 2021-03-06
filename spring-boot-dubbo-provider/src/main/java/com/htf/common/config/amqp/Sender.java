package com.htf.common.config.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author acumes
 * @date 2018/8/2 9:27
 */
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 10000L)
    public void send() {
        this.rabbitTemplate.convertAndSend("foo", "hello world");
    }

}
