package me.motyim.learn.spring.websocket.config;

import me.motyim.learn.spring.websocket.message.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 26-Feb-18
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 10000)
    public void sendRandMessages() {
        template.convertAndSend("/topic/login", new LoginResponse("Visitor"));
    }
}
