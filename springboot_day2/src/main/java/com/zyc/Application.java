package com.zyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//相当于
/*SpringBootApplication = @ComponentScan+@EnableAutoConfiguration+@SpringBootConfiguration*/
@SpringBootApplication          //打war包 需要 继承   SpringBootServletInitializer
@ServletComponentScan //扫描  servlet 注解 servlet 3.0新特性
public class Application extends SpringBootServletInitializer {

    @Override  //打war包使用
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
