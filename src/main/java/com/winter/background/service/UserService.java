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

    public User login(String userName,String password) {
        user.setUserName(userName);
        user.setUserName(password);
        List<User> loginResult = userDao.getUserByExample(user);
        if (loginResult.isEmpty()) {
            return null;
        }

        return loginResult.get(0);
    }

}
