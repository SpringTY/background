package com.winter.background.controller;

import com.winter.background.dao.UserDao;
import com.winter.background.domain.Dept;
import com.winter.background.domain.User;
import com.winter.background.domain.view.UserDeptView;
import com.winter.background.service.DeptService;
import com.winter.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    User user;
    @Autowired
    UserService userService;
    @Autowired
    DeptService deptService;
    @Autowired
    UserDeptView userDeptView;
    @Autowired
    UserDao test;

    /**
     * 以任何形式的方法访问UsersAction，同步访问，后段跳转到Users.html
     * 例如 href=/UsersAction
     * 传值为 UsersList 为 数组，用Thymeleaf接收
     *
     * @param paraMap
     * @return
     */
    @RequestMapping(value = "UsersAction")
    public String getUsers(Map<String, Object> paraMap) {
        List<User> users = userService.getAll();
        paraMap.put("UsersList", users);
        return "Users.html";
    }

    @ResponseBody
    @RequestMapping(value = "text")
    public List<UserDeptView> text() {
        return test.getUserDeptViewByExample(userDeptView);
    }

    /**
     * 进入页面
     *
     * @param request
     * @param paraMap
     * @return
     */
    @GetMapping(value = "userAddAction")
    public String userAddAction(HttpServletRequest request, Map<String, Object> paraMap) {
        User loginUser = (User) request.getSession(true).getAttribute("loginUser");
        paraMap.put("loginUserName", loginUser.getUserNickname());
        paraMap.put("loginUserInfo", loginUser);
        List<Dept> depts = deptService.getAll();
        paraMap.put("depts", depts);
        return "UserAdd";
    }

    @RequestMapping(value = "UpdateUser")
    public String updateUser(@RequestParam("userName") String userName,
                             @RequestParam("userNickName") String userNickName,
                             @RequestParam("password") String password,
                             @RequestParam("userSex") String userSex,
                             @RequestParam("userPhone") String userPhone,
                             @RequestParam("userMail") String userMail,
                             @RequestParam("userDeptName") String userDeptName,
                             @RequestParam("userStatus") String userStatus,
                             @RequestParam("userRegestertime") String userRegestertime,
                             @RequestParam("userPower") String userPower
    ) {
        user.setUserName(userName);
        user.setUserNickname(userNickName);
        user.setPassword(password);
        user.setUserSex(userSex);
        user.setUserPhone(userService.getIntegerSafe(userPhone));
//        user.set
        user.setUserMail(userMail);
        Integer deptIdByDeptName = deptService.getDeptIdByDeptName(userDeptName);
        user.setUserDeptId(deptIdByDeptName);
        user.setUserStatus(userStatus);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(userRegestertime);

        } catch (Exception e) {
            e.printStackTrace();
            date = null;
        }
        if (date == null) {
            return "";
        }
        return "Users.html";
    }

    /**
     * 注册操作
     *
     * @param userName
     * @param userNickName
     * @param password
     * @param userSex
     * @param userPhone
     * @param userMail
     * @param userStatus
     * @param userPower
     * @return
     */
    @PostMapping(value = "addUserAction")
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("userNickName") String userNickName,
                          @RequestParam("password") String password,
                          @RequestParam("userSex") String userSex,
                          @RequestParam("userPhone") String userPhone,
                          @RequestParam("userMail") String userMail,
                          @RequestParam("userDeptId") String userDeptId,
                          @RequestParam("userStatus") String userStatus,
                          @RequestParam("userPower") String userPower
    ) {
        user.setUserName(userName);
        user.setUserNickname(userNickName);
        user.setPassword(password);
        user.setUserSex(userSex);
        user.setUserPhone(userService.getIntegerSafe(userPhone));
        user.setUserMail(userMail);
        user.setUserDeptId(Integer.parseInt(userDeptId));
        user.setUserStatus(userStatus);
        user.setUserPower(userPower);
        user.setUserRegestertime(new Date(new java.util.Date().getTime()));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(
                "add User"
        );
        userService.insertUser(user);
        System.out.println(user);
        return "redirect:/indexAction";
    }
}
