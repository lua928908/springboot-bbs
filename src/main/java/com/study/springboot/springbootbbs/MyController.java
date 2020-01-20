package com.study.springboot.springbootbbs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/")
    public @ResponseBody // @ResponseBody 어노테이션때문에 단순 스트링을 리턴?
    String root() throws Exception{
        return "JSP in Gradle";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
