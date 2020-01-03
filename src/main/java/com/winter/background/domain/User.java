package com.winter.background.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class User {
    Integer userId;
    String userName;
    String userNickname;
    String password;
    String userSex;
    Integer userPhone;
    String userMail;
    Integer userDeptId;
    String userStatus;
    Date userRegestertime;
    String UserPower;
    //private List<User> authorities;

//    @Override
//    public String getUsername() {
//        return this.userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
