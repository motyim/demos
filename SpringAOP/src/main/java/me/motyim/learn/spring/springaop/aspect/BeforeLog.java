package me.motyim.learn.spring.springaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 18, 2018 
 */
public class BeforeLog implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        System.out.println("Before Log :::: Method : "+method.getName()+" , ARGS : " +Arrays.toString(args));
    }
    
    
}
