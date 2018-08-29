package me.learn.lombokdemo.tostring;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/ToString
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(new Person().toString());
    }
}

@ToString
class Person{
    String name;
    int age ;
    List data ;
    static int crashs ;
    @ToString.Exclude String address ;

    Person(){
        name = "Ahmed";
        age = 23 ;
        data = new ArrayList();
        data.add("ali");
        data.add(2);
        crashs = 10 ;
        address = "Alexandria";
    }

}