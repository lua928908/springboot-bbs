package com.study.springboot.springbootbbs.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러로 쓴다는 의미
public class MyController {
    @Autowired
    Member member1;
    @Autowired
    @Qualifier("printerB")
    Printer printer;
    @Autowired
    Member member2;

    @RequestMapping("/")
    public @ResponseBody String root(){
        // 1. Member Bean 가져오기
        member1.print();

        // 2. PrinterB Bean 가져오기
        member1.setPrinter(printer);
        member1.print();

        // 3. 싱글톤인지 확인하기
        if(member1 == member2){
            System.out.println("동일한 객체 입니다.");
        }else{
            System.out.println("서로 다른 객체 입니다.");
        }

        return "Annotation 사용하기";
    }
}
