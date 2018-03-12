package me.motyim.learn.spring.springactivemqinmemory.Listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 12-Mar-18
 */
@Component
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message){
        System.out.println("Message received : "+message);
    }

}
