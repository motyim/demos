package me.motyim.tlsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TlsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlsDemoApplication.class, args);
    }

    @RestController
    public static class HelloController {
        @GetMapping("/hello")
        public  String helloController() {
            return "Hello";
        }
    }

}
