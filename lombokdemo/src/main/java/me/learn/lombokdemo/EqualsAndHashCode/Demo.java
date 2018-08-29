package me.learn.lombokdemo.EqualsAndHashCode;

import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/EqualsAndHashCode
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person();

        person1.age=12;

        System.out.println(person.equals(person));
        System.out.println(person.equals(person1));
        System.out.println(person.hashCode());
    }
}

@EqualsAndHashCode
class Person {

    String name;
    int age ;
    List data ;
    static int crashs ;
    @EqualsAndHashCode.Exclude String address ;
}