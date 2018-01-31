

package me.motyim.learn.spring.SpringTestExample.service;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {
    @Autowired
    MyService ms ;
    
    @Autowired
    ApplicationContext ac ;
    
    @Test
    public void method(){
        System.out.println(ms.method());
        System.out.println(">>>"+ac.getDisplayName());
        Assert.assertEquals("Hello Spring Test", ms.method());
    }
    
}
