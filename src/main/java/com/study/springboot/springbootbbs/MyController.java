package com.study.springboot.springbootbbs;

import com.study.springboot.springbootbbs.jdbc.dao.ISimpleBbsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    /*
        IMyUserDao 라는 인터페이스에 @Mapper를 보고 mybatis에 mapper 디렉토리에
        xml을 실행시키는데 namespace에 이름이 같은애를 실행시킨다. 그중 id가 메소드와 매칭이 되고
        기재되어 있는 query문을 실행한 결과를 resultType에 있는 클래스에게 리턴해준다.
    */

    @Autowired
    private ISimpleBbsDao dao;

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
