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

    @PostMapping(value = {"loginAction"})
    public String login(HttpServletRequest request, Map<String, Object> paraMap, @RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        System.out.println("con input");
        System.out.println(userName);
        System.out.println(password);

        User login = userService.login(userName, password);
        System.out.println("in");
        System.out.println(userName);
        System.out.println(password);
        if (login == null) {
            paraMap.put("error_code", "error");
            return "success.html";
        }
        System.out.println("Login Success");
        request.getSession().setAttribute("loginUser", login);
        return "redirect:indexAction";
    }

    @RequestMapping(value = "indexAction")
    public String index(HttpServletRequest request, Map<String, Object> paraMap) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        paraMap.put("loginUserName", loginUser.getUserNickname());
        paraMap.put("loginUserInfo", loginUser);
        return "Users.html";
    }

    @RequestMapping({"", "login"}) //这里为空或者是login都能进入该方法
    public String login() {
        return "login";
    }


}
