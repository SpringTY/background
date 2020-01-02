package com.winter.background.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class Job {
    Integer jobId;
    String jobName;
    String jobStatus;
    Date creatDate;
}
