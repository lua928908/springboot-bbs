package com.study.springboot.springbootbbs;

import com.study.springboot.springbootbbs.bean.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringbootBbsApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringbootBbsApplication.class, args);

        // 1.Ioc 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    }
}
