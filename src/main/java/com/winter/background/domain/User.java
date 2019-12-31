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
    String userDeptId;
    String userStatus;
    Date userRegestertime;
    String UserPower;
}
