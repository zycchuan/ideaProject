package com.zyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//相当于
/*SpringBootApplication = @ComponentScan+@EnableAutoConfiguration+@SpringBootConfiguration*/
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
