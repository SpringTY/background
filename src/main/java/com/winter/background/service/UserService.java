package com.winter.background.service;

import com.winter.background.dao.UserDao;
import com.winter.background.domain.User;
import com.winter.background.domain.view.UserDeptView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;
    @Autowired
    private UserDeptView userDeptView;

    public User login(String userName, String password) {
        user.setUserName(userName);
        user.setPassword(password);
        List<User> loginResult = userDao.getUserByExample(user);
        if (loginResult.isEmpty()) {
            return null;
        }
        System.out.println("登录用户信息:\n" + loginResult.get(0));
        return loginResult.get(0);
    }

    public Integer getIntegerSafe(String integer) {
        Integer res = null;
        try {
            res = Integer.parseInt(integer);
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    public List<UserDeptView> getAllUserDeptView() {
        return userDao.getUserDeptViewByExample(userDeptView);
    }

    public void insertUser(User u){
//        u.setUserId();
        userDao.insertUser(user);
    }
    public List<User> getAll() {
        return userDao.getUserByExample(user);
    }
}
