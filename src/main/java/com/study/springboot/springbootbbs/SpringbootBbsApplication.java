package com.study.springboot.springbootbbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 여기서 bean 자동검색, 등록
public class SpringbootBbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootBbsApplication.class, args); // 여기서 내장 톰캣 실행, webapplication 실행
    }
}
