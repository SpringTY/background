package com.winter.background.service;

import com.winter.background.dao.UserDao;
import com.winter.background.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;

    public User login(String userName, String password) {
        user.setUserName(userName);
        user.setPassword(password);
        System.out.println("input user:\n"+user);
        List<User> loginResult = userDao.getUserByExample(user);
        if (loginResult.isEmpty()) {
            return null;
        }
        System.out.println("登录用户信息:\n"+loginResult.get(0));
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
    public List<User> getAll(){
        return userDao.getUserByExample(user);
    }
}
