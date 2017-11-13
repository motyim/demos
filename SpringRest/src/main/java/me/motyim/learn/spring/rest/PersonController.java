package me.motyim.learn.spring.rest;

import me.motyim.learn.spring.dto.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 13-Nov-17
 */
@RestController
public class PersonController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public Person greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Person(counter.incrementAndGet(),
                String.format(template, name));
    }
}
