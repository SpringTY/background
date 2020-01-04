package com.winter.background.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Dept {
    Integer deptId;
    Integer deptRegionId;
    String deptName;
    String deptRegionName;
}
