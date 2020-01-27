package com.study.springboot.springbootbbs;

import com.study.springboot.springbootbbs.jdbc.MyUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private MyUserDAO userDao;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "JDBC Templete 사용하기";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model){
        model.addAttribute("users", userDao.list()); // userDao.list()를 호출하면 쿼리문의 실행결과를 Modal의 users로 담게된다.
        return "userlist";
    }

}
