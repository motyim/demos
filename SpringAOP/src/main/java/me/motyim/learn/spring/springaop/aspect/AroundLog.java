package me.motyim.learn.spring.springaop.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 18, 2018 
 */
public class AroundLog implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        
        System.out.println("AroungLog ::: method : "+mi.getMethod().getName()+" , begin...");
        
        try{
            Object proceed = mi.proceed();
            System.out.println("AroungLog ::: method : "+mi.getMethod().getName()+" , Finished...");
            return proceed;
        }catch(ArithmeticException ex){
            System.out.println("AroungLog ::: method : "+mi.getMethod().getName()+" , exception...");
            throw ex;
        }
        
    }

}
