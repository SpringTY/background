package com.winter.background.dao;

import com.winter.background.domain.DeptRegion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRegionDao {
    List<DeptRegion> getDeptRegionByExample(DeptRegion example);
    void updateDeptRegion(DeptRegion deptRegion);
    void insertDeptRegion(DeptRegion deptRegion);
}
