package com.study.springboot.springbootbbs;

import com.study.springboot.springbootbbs.jdbc.dao.SimpleBbsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @Autowired
    private SimpleBbsDao dao;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "JDBC Templete 사용하기";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model){
        model.addAttribute("list", dao.listDao());
        return "/list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model){
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm(){
        return "writeForm";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model){
        dao.writeDao(
                request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content")
        );
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model){
        dao.deleteDao(request.getParameter("id"));
        return "redirect:list";
    }

}
