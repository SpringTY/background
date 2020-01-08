package com.winter.background.controller;

import com.winter.background.domain.Dept;
import com.winter.background.domain.DeptRegion;
import com.winter.background.domain.User;
import com.winter.background.service.DeptService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.jgss.HttpCaller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DeptController {
    @Autowired
    Dept dept;
    @Autowired
    DeptService deptService;


    @RequestMapping("deptInfoAction")
    public String getDepts(HttpServletRequest request,
                           Map<String, Object> paraMap){
        User loginUser = (User) request.getSession(true).getAttribute("loginUser");
        paraMap.put("loginUserName", loginUser.getUserNickname());
        paraMap.put("loginUserInfo", loginUser);
        List<Dept> depts = deptService.getAll();
        paraMap.put("deptInfo", depts);
        return "Depts.html";
    }

    @RequestMapping("deptAdd")
    public String deptAdd(HttpServletRequest request, Map<String, Object> paraMap) {
        User loginUser = (User) request.getSession(true).getAttribute("loginUser");
        paraMap.put("loginUserName", loginUser.getUserNickname());
        paraMap.put("loginUserInfo", loginUser);
        return "DeptAdd.html";
    }

    @RequestMapping("deptAddAction")
    public String addDept(@RequestParam("deptName") String deptName,
                          @RequestParam("deptRegionName") String deptRegionName) {
        dept.setDeptName(deptName);
        dept.setDeptRegionName(deptRegionName);
//        dept.setDeptId(null);
        deptService.insertDept(dept);
        return "redirect:/deptInfoAction";
    }

    @GetMapping("upadteDept")
    public String updateDept(String deptId,HttpServletRequest request, Map<String, Object> paraMap) {
        Dept dept = new Dept();
        dept.setDeptId(Integer.parseInt(deptId));
        request.getSession(true).setAttribute("deptId", deptId);
        List<Dept> deptByExample = deptService.getDeptByExample(dept);
        Dept dept1 = deptByExample.get(0);
        paraMap.put("deptInfoAlter", dept1);
        List<Dept> depts = deptService.getAll();
        paraMap.put("depts", depts);
        User loginUser = (User) request.getSession(true).getAttribute("loginUser");
        paraMap.put("loginUserName", loginUser.getUserNickname());
        paraMap.put("loginUserInfo", loginUser);
        return "DeptAlter.html";
    }

    @RequestMapping("updateDeptAction")
    public String updateDeptAction(HttpServletRequest request,
                                   @RequestParam("deptName") String deptName,
                                   @RequestParam("deptRegionName") String deptRegionName) {
        String deptId = (String) request.getSession(true).getAttribute("deptId");
        Dept example = new Dept();
        List<Dept> deptList =  deptService.getDeptByExample(example);
        Dept dept2 = deptList.get(0);
        dept2.setDeptId(Integer.parseInt(deptId));
        dept2.setDeptRegionName(deptRegionName);
        dept2.setDeptName(deptName);
        deptService.updateDept(dept2);
        request.getSession(true).removeAttribute("deptId");
        return "redirect:/deptInfoAction";
    }


}
