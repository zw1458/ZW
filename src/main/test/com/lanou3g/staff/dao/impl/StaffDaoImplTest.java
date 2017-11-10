package com.lanou3g.staff.dao.impl;

import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class StaffDaoImplTest {

    @Resource
    private StaffDao staffDao;



    @Test
    public void test(){

        Staff staff = new Staff("和他","wz","1213","男","2015-09-06");

        List<Staff> all = staffDao.findAll();
        System.out.println(all);
    }


}