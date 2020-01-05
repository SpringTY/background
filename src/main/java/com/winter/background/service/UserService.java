package com.winter.background.service;

import com.winter.background.dao.DeptDao;
import com.winter.background.dao.UserDao;
import com.winter.background.domain.Dept;
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
    private DeptDao deptDao;

    public User login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        List<User> loginResult = userDao.getUserByExample(user);
        if (loginResult.isEmpty() || loginResult.get(0).getUserStatus().equals("0")) {
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

    public String toStringSafa(String s) {
        return (s.equals("") || s == null) ? null : s;
    }

    public UserDeptView toDeptView(User user) {
//        userDeptView.set
        UserDeptView userDeptView = new UserDeptView();
        Dept dept = new Dept();
        userDeptView.setUserPower(user.getUserPower());
        userDeptView.setUserId(user.getUserId());
        userDeptView.setUserName(user.getUserNickname());
        userDeptView.setPassword(user.getPassword());
        userDeptView.setUserSex(user.getUserSex());
        userDeptView.setUserPhone(user.getUserPhone());
        userDeptView.setUserMail(user.getUserMail());
        userDeptView.setUserDeptId(user.getUserDeptId());
        userDeptView.setUserStatus(user.getUserStatus());
        userDeptView.setUserRegestertime(user.getUserRegestertime());
        userDeptView.setUserPower(user.getUserPower());
        dept.setDeptId(user.getUserDeptId());
        List<Dept> deptByExample = deptDao.getDeptByExample(dept);
        Dept deptResult = deptByExample.get(0);
        userDeptView.setDeptId(deptResult.getDeptId());
        userDeptView.setDeptName(deptResult.getDeptName());
        userDeptView.setDeptRegionId(dept.getDeptRegionId());
        userDeptView.setDeptRegionName(dept.getDeptRegionName());
        return userDeptView;
    }

    public List<UserDeptView> getAllUserDeptView() {

        return userDao.getUserDeptViewByExample(new UserDeptView());
    }

    public List<UserDeptView> getUserDeptViewByExample(UserDeptView example) {
        return userDao.getUserDeptViewByExample(example);
    }

    public void insertUser(User u) {
//        u.setUserId();
        User user = new User();
        userDao.insertUser(user);
    }

    public List<User> getUserByExample(User example) {
        return userDao.getUserByExample(example);
    }

    public List<User> getAll() {

        User user = new User();
        return userDao.getUserByExample(user);
    }
}
