package me.learn.lombokdemo.var;

import lombok.var;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/var
 */
public class Demo {

    public static void main(String[] args) {
        var x = "hello world";
        System.out.println(x);

        x = "mohamed ahmed elmotyim";
        System.out.println(x);

//        x =10 ;

    }
}
