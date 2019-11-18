package com.zyc.test;

import com.zyc.Application;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //底层用junit 继承了SpringJUnit4ClassRunner
@SpringBootTest(classes = {Application.class}) //启动整个springboot工程
public class SpringbootTestDemo {

    @Test
    public void  testOne(){
        System.out.println(12311);
        TestCase.assertEquals(1,1);//断言
    }
    @Before //test之前 //@After test之后
    public void before1(){
        System.out.println("before");
    }
}
