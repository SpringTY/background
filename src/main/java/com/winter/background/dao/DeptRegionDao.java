package com.winter.background.dao;

import com.winter.background.domain.DeptRegion;

import java.util.List;

public interface DeptRegionDao {
    List<DeptRegion> getDeptRegionByExample(DeptRegion example);
    void update(DeptRegion deptRegion);
    void insert(DeptRegion deptRegion);
}
