package com.winter.background.dao;

import com.winter.background.domain.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao {
    List<Job> getJobByExample(Job example);
    void updateJob(Job job);
    void insertJob(Job job);
}
