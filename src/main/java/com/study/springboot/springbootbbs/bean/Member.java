package com.study.springboot.springbootbbs.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {
    @Value("홍길동") // @value는 setter에 역할을 한다, 객체 생성할때 값 지정가능
    private String name;
    @Value("도사")
    private String nickname;
    @Autowired // 자동으로 의존성 주입받음
    @Qualifier("printerA") // 주입할수있는게 여러개라 구체적으로 뭐받을지 표기함 @Qualifier 혹은 @Primary
    private Printer printer;

    public Member() {}

    public Member(String name, String nickname, Printer printer){
        this.name = name;
        this.nickname = nickname;
        this.printer = printer;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public void setPrinter(Printer printer){
        this.printer = printer;
    }
    public void print(){
        printer.print("Hello " + name + " : " + nickname);
    }
}
