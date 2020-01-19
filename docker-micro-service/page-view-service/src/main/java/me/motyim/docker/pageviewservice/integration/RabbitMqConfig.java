package me.motyim.docker.pageviewservice.integration;

import me.motyim.demo.docker.model.events.PageViewEvent;
import me.motyim.docker.pageviewservice.domain.PageView;
import me.motyim.docker.pageviewservice.repository.PageViewRepo;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import javax.xml.bind.JAXB;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@Configuration
public class RabbitMqConfig {

    public static final String INBOUND_QUEUE_NAME = "pageviewqueue";
    private static final String AMQP_CHANNEL = "amqpInputChannel";

    @Bean
    Queue queue(){
        return new Queue(INBOUND_QUEUE_NAME,false);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(INBOUND_QUEUE_NAME);
        return container;
    }

    @Bean(name = AMQP_CHANNEL)
    public MessageChannel amqpInputChannel(){
        return MessageChannels.direct().get();
    }

    @Bean
    public AmqpInboundChannelAdapter amqpInboundChannelAdapter(SimpleMessageListenerContainer listenerContainer,
                                                               @Qualifier(value = AMQP_CHANNEL) MessageChannel inboundChannel){
        AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer);
        adapter.setOutputChannel(inboundChannel);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = AMQP_CHANNEL)
    public MessageHandler pageViewMessageHandler(PageViewRepo repo){
        return message -> {
            System.out.println("Get message...");
            String xmlMessage = (String) message.getPayload();
            System.out.println(xmlMessage);
            InputStream stream = new ByteArrayInputStream(xmlMessage.getBytes(StandardCharsets.UTF_8));
            PageViewEvent pageViewEvent = JAXB.unmarshal(stream, PageViewEvent.class);
            PageView pageView = new PageView();
            pageView.setPageUrl(pageViewEvent.getPageUrl());
            pageView.setCorrelationId(pageViewEvent.getCorrelationId());
            pageView.setTime(pageViewEvent.getTime());
            repo.save(pageView);
            System.out.println("End Handler ...");
        };
    }
}
