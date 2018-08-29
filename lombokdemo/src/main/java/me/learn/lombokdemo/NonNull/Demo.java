package me.learn.lombokdemo.NonNull;

import lombok.NonNull;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/NonNull
 */
public class Demo {
    public static void main(String[] args) {

        String s = null ;
        Person person = new Person(s);

    }
}


class Person{

    private String name ;

    Person(@NonNull String name){
        this.name = name ;
    }

}