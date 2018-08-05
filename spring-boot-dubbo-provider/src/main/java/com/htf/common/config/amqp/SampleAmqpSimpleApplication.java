package com.htf.common.config.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Date;

/**
 * @author acumes
 * @date 2018/8/2 9:27
 */
@Configuration
@RabbitListener(queues = "foo")
public class SampleAmqpSimpleApplication {
    @Bean
    public Sender mySender() {
        return new Sender();
    }

    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload String foo) {
        //邮件发送
        System.out.println(new Date() + ": " + foo);
    }
}
