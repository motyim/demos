package me.motyim.docker.pageviewclient.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String OUTBOUND_QUEUE_NAME = "pageviewqueue";
    public static final String OUTBOUND_ADUIT_QUEUE_NAME = "aduitpageviewqueue";
}
