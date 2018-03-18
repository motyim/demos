package me.motyim.learn.spring.springaop.aspect;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 18, 2018 
 */
public class ThrowLog implements ThrowsAdvice{
    
    public void afterThrowing(ArithmeticException err) throws Throwable{
        System.out.println("ThrowLog... ArithmetException");
    }
}
