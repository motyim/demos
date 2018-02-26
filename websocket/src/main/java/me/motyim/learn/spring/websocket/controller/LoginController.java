package me.motyim.learn.spring.websocket.controller;

import me.motyim.learn.spring.websocket.message.LoginResponse;
import me.motyim.learn.spring.websocket.message.Person;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 26-Feb-18
 */
@Controller
public class LoginController {



    @MessageMapping("/login")
    @SendTo("/topic/login")
    public LoginResponse login(Person person){
        return new LoginResponse(person.getName());
    }

}
