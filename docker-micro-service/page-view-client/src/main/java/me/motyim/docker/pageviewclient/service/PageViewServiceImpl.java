package me.motyim.docker.pageviewclient.service;

import me.motyim.demo.docker.model.events.PageViewEvent;
import me.motyim.docker.pageviewclient.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.io.Writer;

@Service
public class PageViewServiceImpl implements PageViewService {

    private RabbitTemplate rabbitTemplate ;

    @Autowired
    public PageViewServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendPageViewEvent(PageViewEvent pageViewEvent) {
        Writer writer = new StringWriter();
        JAXB.marshal(pageViewEvent,writer);
        String xmlMessage = writer.toString();

        System.out.println("Sending message...");
        System.out.println(xmlMessage);

        rabbitTemplate.convertAndSend(RabbitMqConfig.OUTBOUND_QUEUE_NAME,xmlMessage);
        rabbitTemplate.convertAndSend(RabbitMqConfig.OUTBOUND_ADUIT_QUEUE_NAME,pageViewEvent.getCorrelationId());

    }
}
