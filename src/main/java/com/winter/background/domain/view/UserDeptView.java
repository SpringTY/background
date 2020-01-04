package com.winter.background.domain.view;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
@Data
public class UserDeptView {
    // from user
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

    // from dept
    Integer deptId;
    Integer deptRegionId;
    String deptName;
    String deptRegionName;
}
