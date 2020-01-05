package com.winter.background.service;

import com.winter.background.dao.DeptDao;
import com.winter.background.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public Integer getDeptIdByDeptName(String deptName) {
        Dept dept = new Dept();
        dept.setDeptName(deptName);
        List<Dept> deptByExample = deptDao.getDeptByExample(dept);
        if (deptByExample.isEmpty()) {
            return null;
        }
        return deptByExample.get(0).getDeptId();
    }

    public String getDeptNameByDeptId(Integer deptId) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        List<Dept> deptByExample = deptDao.getDeptByExample(dept);
        if (deptByExample.isEmpty()) {
            return null;
        }
        return deptByExample.get(0).getDeptName();
    }

    public List<Dept> getAll() {
        Dept dept = new Dept();
        return deptDao.getDeptByExample(dept);
    }
}
