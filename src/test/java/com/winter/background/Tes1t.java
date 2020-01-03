package com.winter.background;

import com.winter.background.dao.UserDao;
import com.winter.background.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tes1t {
    @Autowired
    UserDao userDao;
    @Test
    public void test(){
        List<User> userByExample = userDao.getUserByExample(new User());
        System.out.println(userByExample);
//        User user = new User();
//        user.setUserPhone(1112);
//        user.setPassword("liuwei");
//        user.setUserDeptId(1);
//        user.setUserId(2);
//        user.setUserNickname("2");
//        user.setUserSex("1");
//        user.setUserName("sd");
//        user.setUserMail("s");
//        user.setUserPower("s");
//        user.setUserStatus("s");
//        user.setUserRegestertime(new Date(new java.util.Date().getTime()));
////        userDao.insertUser(user);
//        userDao.updateUser(user);
    }
}
