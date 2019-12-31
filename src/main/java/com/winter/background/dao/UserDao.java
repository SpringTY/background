package com.winter.background.dao;

import com.winter.background.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserByExample(User example);
    void insertUser(User user);
    void updateUser(User user);
}
