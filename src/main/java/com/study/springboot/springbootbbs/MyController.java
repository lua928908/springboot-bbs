package com.study.springboot.springbootbbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String test1(@ModelAttribute("dto") ContentDto contentDto, BindingResult result){ // contentDto라는 값을 Modal에 dto라는 key이름으로 저장하는 의미
        String page = "done";
        System.out.println(contentDto);

        ContentValidator validator = new ContentValidator();
        validator.validate(contentDto, result); // validate메서드를 통해 contentDto를 검사하고 에러가있으면 result에 담음
        if(result.hasErrors()){
            page = "create";
        }

        return page;
    }

    @RequestMapping("/done")
    public String test2(){
        return "done";
    }
}
