package com.winter.background.dao;

import com.winter.background.domain.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {
    List<Dept> getDeptByExample(Dept example);
    void updateDept(Dept dept);
    void insertDept(Dept dept);
    Integer getDeptIdByDeptName(String userDeptName);
}
