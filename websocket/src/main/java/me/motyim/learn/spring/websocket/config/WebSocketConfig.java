package me.motyim.learn.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 26-Feb-18
 */
@Configuration
//enables WebSocket message handling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //enable a simple memory-based message broker to carry the Login messages back to the client
        //on destinations prefixed with "/topic"
        registry.enableSimpleBroker("/topic");

        //It also designates the "/app" prefix for messages that are bound for @MessageMapping -annotated methods.
        registry.setApplicationDestinationPrefixes("/app");

    }


    /*
    The registerStompEndpoints() method registers the "/login-system-websocket" endpoint,
    enabling SockJS fallback options so that alternate transports may be used if WebSocket
    is not available. The SockJS client will attempt to connect to "/gs-guide-websocket"
    and use the best transport available (websocket, xhr-streaming, xhr-polling, etc).
     */

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/login-system-websocket").withSockJS();
    }
}
