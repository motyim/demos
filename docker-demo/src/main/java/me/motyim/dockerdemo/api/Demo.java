package me.motyim.dockerdemo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @GetMapping("api/hello")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>("Hello Docker!", HttpStatus.OK);
    }
}
