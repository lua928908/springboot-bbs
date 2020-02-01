package com.study.springboot.springbootbbs;

import com.study.springboot.springbootbbs.jdbc.dao.ISimpleBbsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
    /*
        IMyUserDao 라는 인터페이스에 @Mapper를 보고 mybatis에 mapper 디렉토리에
        xml을 실행시키는데 namespace에 이름이 같은애를 실행시킨다. 그중 id가 메소드와 매칭이 되고
        기재되어 있는 query문을 실행한 결과를 resultType에 있는 클래스에게 리턴해준다.
    */

    @Autowired
    private ISimpleBbsDao dao;

    @RequestMapping("/list")
    public String userListPage(Model model){
        model.addAttribute("list", dao.listDao());

        int nTotalCount = dao.articleCount();
        System.out.println("Count : " + nTotalCount);
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
        String sName = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", sName);
        map.put("title", sTitle);
        map.put("content", sContent);

        int nResult = dao.writeDao(map);
        System.out.println("write : " + nResult);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model){
        dao.deleteDao(request.getParameter("id"));
        return "redirect:list";
    }

}
