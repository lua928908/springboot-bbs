package com.study.springboot.springbootbbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
