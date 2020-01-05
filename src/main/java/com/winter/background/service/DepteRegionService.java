package com.winter.background.service;

import com.winter.background.dao.DeptRegionDao;
import com.winter.background.domain.DeptRegion;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.DerEncoder;

import java.util.List;

public class DepteRegionService {
    @Autowired
    private DeptRegionDao depteRegionDao;
    @Autowired
    private DeptRegion deptRegion;

    public List<DeptRegion> getAllDeprRegion() {
        return depteRegionDao.getDeptRegionByExample(new DeptRegion());
    }

    public List<DeptRegion> getByExample(DeptRegion deptRegion) {
        return depteRegionDao.getDeptRegionByExample(deptRegion);
    }

    public void updateDeptRegion(DeptRegion deptRegion) {
        depteRegionDao.updateDeptRegion(deptRegion);
    }

    public void insertDeptRegion(DeptRegion deptRegion) {
        depteRegionDao.insertDeptRegion(deptRegion);
    }
}
