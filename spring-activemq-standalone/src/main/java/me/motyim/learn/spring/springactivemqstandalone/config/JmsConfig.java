package me.motyim.learn.spring.springactivemqstandalone.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 14-Mar-18
 */
@Configuration
public class JmsConfig {

    @Value("${activemq.broker-url}")
    private String brokerURL ;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("standalone.queue");
    }

    //to connect with out jms
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerURL);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(activeMQConnectionFactory());
    }

}
