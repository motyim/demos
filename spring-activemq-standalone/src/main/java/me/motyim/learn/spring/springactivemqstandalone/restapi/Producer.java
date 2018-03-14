package me.motyim.learn.spring.springactivemqstandalone.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 14-Mar-18
 */
@RestController
@RequestMapping("/rest/publish")
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable String message){
        jmsTemplate.convertAndSend(queue,message);
        return "Published Successfully...";
    }

}
