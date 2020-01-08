package com.winter.background.controller;

import com.winter.background.domain.Dept;
import com.winter.background.domain.DeptRegion;
import com.winter.background.service.DeptService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class DeptRegionController {
    @Autowired
    Dept dept;
    @Autowired
    DeptService deptService;

    @RequestMapping("getDeptReions")
    public void getDeptRegions(HttpServletRequest request, Map<String, Object> paraMap) {
        List<Dept> deptRegions = deptService.getAll();
        System.out.println("+++++++++++________________+_-----------------=_+");
        System.out.println(deptRegions);
        paraMap.put("DeptRegions", deptRegions);
    }
}
