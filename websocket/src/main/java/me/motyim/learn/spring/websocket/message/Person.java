package me.motyim.learn.spring.websocket.message;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 26-Feb-18
 */
public class Person {

    private String name ;

    Person(){}

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
