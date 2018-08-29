package me.learn.lombokdemo.cleanup;

import lombok.Cleanup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 8/29/2018
 * https://projectlombok.org/features/Cleanup
 */
public class Demo {
    public static void main(String[] args) throws FileNotFoundException {

        //to read form resource folder
        ClassLoader classLoader = Demo.class.getClassLoader();
        File file = new File(classLoader.getResource("test").getFile());

        @Cleanup Scanner in = new Scanner(file);
        System.out.println(in.nextLine());

    }
}
