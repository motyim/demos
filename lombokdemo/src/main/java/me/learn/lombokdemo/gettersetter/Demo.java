package me.learn.lombokdemo.gettersetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/GetterSetter
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.getAge();
    }
}

class Person {
    /**
     * Age of the person.
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    @Getter
    @Setter
    private int age = 10;

    /**
     * Name of the person.
     * -- SETTER --
     * Changes the name of this person.
     *
     * @param name The new value.
     */
    @Setter(AccessLevel.PRIVATE) private String name;
}
