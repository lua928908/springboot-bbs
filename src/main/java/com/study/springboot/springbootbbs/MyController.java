package com.study.springboot.springbootbbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/test")
    public String test(@RequestParam("id") String id, @RequestParam("name") String name, Model model){

        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "test";
    }

    @RequestMapping("/test2/{id}/{name}") // 여기있는 id,name 이 @PathVariable에 매핑됨
    public String test2(@PathVariable String id, @PathVariable String name, Model model){

        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "test2";
    }
}
