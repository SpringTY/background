package com.winter.background;

import com.winter.background.dao.JobDao;
import com.winter.background.dao.UserDao;
import com.winter.background.dao.DeptDao;
import com.winter.background.dao.DeptRegionDao;
import com.winter.background.domain.Dept;
import com.winter.background.domain.DeptRegion;
import com.winter.background.domain.Job;
import com.winter.background.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tes1t {
    @Autowired
    UserDao userDao;
    @Autowired
    DeptDao deptDao;
    @Autowired
    DeptRegionDao deptRegionDao;
    @Autowired
    JobDao jobDao;
    @Test
    public void test(){
//        List<User> userByExample = userDao.getUserByExample(new User());
//        List<Dept> deptByExample = deptDao.getDeptByExample(new Dept());
//        List<DeptRegion> deptRegionByExample = deptRegionDao.getDeptRegionByExample(new DeptRegion());
        List<Job> jobByExample = jobDao.getJobByExample(new Job());
    }
}
