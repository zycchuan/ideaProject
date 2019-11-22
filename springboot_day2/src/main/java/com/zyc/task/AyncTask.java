package com.zyc.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AyncTask {

    public void  test1() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(1000L);

        long end = System.currentTimeMillis();

        System.out.println("test1:"+(end-start));
    }
    public void  test2() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(2000L);

        long end = System.currentTimeMillis();

        System.out.println("test2:"+(end-start));
    }
    public void  test3() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(3000L);

        long end = System.currentTimeMillis();

        System.out.println("test3:"+(end-start));
    }


    public Future<String> test4() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(4000L);

        long end = System.currentTimeMillis();
        System.out.println("test4:"+(end-start));
        return new AsyncResult<String>("返回结果1："+(end-start));
    }
}
