package me.motyim.learn.spring.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 13-Nov-17
 */
@RestController
public class Hello {

    @RequestMapping("/")
    public String Main(){
        return "new home...";
    }

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hello Spring Boot..";
    }


}

