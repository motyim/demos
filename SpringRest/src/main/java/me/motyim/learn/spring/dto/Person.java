package me.motyim.learn.spring.dto;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 13-Nov-17
 */
public class Person {

    private final long id;
    private final String content;

    public Person(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
