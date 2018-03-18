package me.motyim.learn.spring.springaop.app;

import me.motyim.learn.spring.springaop.classes.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 18, 2018
 */
public class Main_Type1 {

    public static void main(String[] args) {
        
        ApplicationContext app = new ClassPathXmlApplicationContext("config_type1.xml");
        Calculator calculator = (Calculator)app.getBean("proxy");
        
        calculator.add(2, 3);
        
        System.out.println("--------------- MAIN --------------");
    
        calculator.div(2, 0);
    }
}
