package me.motyim.learn.spring.springactivemqinmemory.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 12-Mar-18
 */
@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("inmemory.queue");
    }

}
