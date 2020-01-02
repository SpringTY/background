package com.winter.background.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class DeptRegion {
    Integer deptRegionId;
    String deptRegionName;
}
