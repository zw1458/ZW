package com.lanou3g.staff.service.impl;

import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;


    @Override
    public void login(Staff staff) {

        staffDao.save(staff);
    }

    @Override
    public boolean save(Staff staff) {
        staffDao.save(staff);
        return true;
    }

    @Override
    public boolean delete(Staff staff) {
        staffDao.delete(staff);
        return true;
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public Staff findById(Serializable id) {
        return null;
    }

    @Override
    public boolean update(Staff staff) {
        return true;
    }

    @Override
    public boolean saveOrUpdate(Staff staff) {
        return true;
    }

    @Override
    public List<Staff> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }







    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
