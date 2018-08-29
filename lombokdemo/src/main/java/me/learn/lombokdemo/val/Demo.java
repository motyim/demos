package me.learn.lombokdemo.val;

import lombok.val;

import java.util.HashMap;


/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @see <https://projectlombok.org/features/val>
 */

public class Demo {

    public static void main(String[] args) {

        // final HashMap<Integer, String> map = new HashMap<Integer, String>();;
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }

    }
}
