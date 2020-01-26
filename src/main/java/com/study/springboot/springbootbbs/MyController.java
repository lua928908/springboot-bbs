package com.study.springboot.springbootbbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("/")
    public String root(Model model) throws Exception{
        List<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        model.addAttribute("lists", list);
        model.addAttribute("ObjectTest", "테스트입니다.");
        model.addAttribute("name", "홍길동");
        return "index";
    }

    @RequestMapping("/create")
    public String test1(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result){
        /*
            @ModelAttribute("dto") -> contentDto를 Model에 dto라는 key로 넣어주겠다는 의미.
            @Valid -> 파라미터가 들어올때 contentDto를 항상 검증하겠다는 의미.
            BindingResult result -> 유효성 검증을한 contentDto에 에러가 있다면 result에 에러가 담김.
        */
        String page = "done";
        System.out.println(contentDto);

        if(result.hasErrors()){
//            if(result.getFieldError("writer") != null){
//                System.out.println("1:"+result.getFieldError("writer").getCode());
//            }
//            if(result.getFieldError("content") != null){
//                System.out.println("2:"+result.getFieldError("content").getCode());
//            }

            if(result.getFieldError("writer") != null){
                System.out.println("1:"+result.getFieldError("writer").getDefaultMessage());
            }
            if(result.getFieldError("content") != null){
                System.out.println("2:"+result.getFieldError("content").getDefaultMessage());
            }

            page = "create";
        }

        return page;
    }

    @RequestMapping("/done")
    public String test2(){
        return "done";
    }
}
