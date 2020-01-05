package com.winter.background.controller;

import com.winter.background.dao.DeptDao;
import com.winter.background.dao.DeptRegionDao;
import com.winter.background.domain.Dept;
import com.winter.background.service.DeptService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.HeadlessToolkit;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.spi.LocaleServiceProvider;

public class DeptController {
    @Autowired
    Dept dept;
    @Autowired
    DeptService deptService;

    @RequestMapping("deptInfoAction")
    public String getDepts(Map<String, Object> paraMap) {
        List<Dept> depts = deptService.getAllDept();
        paraMap.put("DeptsList", depts);
        return "Depts.html";
    }

//    @GetMapping("deptAddAction")
//    public String deptAddAction(HttpServletRequest request, Map<String, Object>) {
//
//    }
    @RequestMapping("deptUpdateAction")
    public String updateDepte(@RequestParam("deptName") String deptName) {
        dept.setDeptName(deptName);
        deptService.updateDept(dept);
        return "Depts.html";
    }

    @PostMapping("deptSelectAction")
    public String selectDept(HttpServletRequest request,
                             Map<String, Object> paraMap,
                             @RequestParam("deptName") String deptName) {
        dept.setDeptName(deptName);
        List<Dept> depts = deptService.getDeptByExample(dept);
        Dept res = depts.get(0);
        paraMap.put("DeptsInfo", res);
        return "Depts.html";
    }

}
