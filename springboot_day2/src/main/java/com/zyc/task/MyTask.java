package com.zyc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    //@Scheduled(fixedRate = 2000)
    public void test1(){
        System.out.println(123);
    }
}
