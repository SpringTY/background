package com.winter.background.service;

import com.winter.background.dao.DeptDao;
import com.winter.background.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeptService {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private Dept dept;

    public List<Dept> getAllDept() {
        return deptDao.getDeptByExample(new Dept());
    }

    public List<Dept> getDeptByExample(Dept example) {
        return deptDao.getDeptByExample(example);
    }

    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }

    public void insertDept(Dept dept) {
        deptDao.insertDept(dept);
    }

    public Integer getDeptIdByDeptName(String userDeptName) {
        return deptDao.getDeptIdByDeptName(userDeptName);
    }

    public String toStringSafa(String s) {
        return (s.equals("") || s == null) ? null : s;
    }
}
