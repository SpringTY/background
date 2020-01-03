package com.winter.background.controller;

import com.winter.background.domain.User;
import com.winter.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping(value = "index2")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, Object> paraMap, @RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        User login = userService.login(userName, password);
        if (login == null) {
            return "Error";
        }
        request.getSession().setAttribute("loginUser", login);
        return "redirect:/index.html";
    }

    @RequestMapping({"", "login"}) //这里为空或者是login都能进入该方法
    public String login() {
        return "login";
    }
}
