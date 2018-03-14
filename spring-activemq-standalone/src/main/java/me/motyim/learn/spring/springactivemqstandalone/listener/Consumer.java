package me.motyim.learn.spring.springactivemqstandalone.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 14-Mar-18
 */
@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue")
    public void listener(String message){
        System.out.println("Message received : "+ message);
    }

}
