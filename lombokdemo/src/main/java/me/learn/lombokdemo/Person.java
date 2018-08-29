package me.learn.lombokdemo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class  Person {
    @Setter
    @Getter
    private String name ;

    private int age ;
}
