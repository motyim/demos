package me.motyim.learn.spring.springaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 18, 2018
 */
public class AfterLog implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnVal, Method method, Object[] args, Object o1) throws Throwable {
        System.out.println("After Log :::: Method : " + method.getName()
                + " , ARGS : " + Arrays.toString(args)
                + ", return Val" + returnVal);
    }

}
