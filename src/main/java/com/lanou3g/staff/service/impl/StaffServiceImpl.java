package com.lanou3g.staff.service.impl;

import com.lanou3g.page.domain.Page;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;


    @Override
    public Staff login(Staff staff) {

        return staffDao.findStaffByLoginNameAndLoginPwd(staff);
    }

    @Override
    public boolean save(Staff staff) {
        staffDao.save(staff);
        return true;
    }


    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Post> getPostByDeptId(String deptId) {
        return staffDao.getPostByDeptId(deptId);
    }

    @Override
    public Staff findAllByStaffId(int staffId) {
        return staffDao.findAllByStaffId(staffId);
    }

    @Override
    public List<Staff> getStaffByPostId(String postId) {
        return staffDao.getStaffByPostId(postId);
    }


    @Override
    public List<Staff> getStaffByDeptId(String deptId) {
        return staffDao.getStaffByDeptId(deptId);
    }

    @Override
    public List<Staff> getStaffByStaffName(String staffName) {
        return staffDao.getStaffByStaffName(staffName);
    }

    /**
     *
     * @param staff
     * @param pageNum     当前的页
     * @param pageSize    每页显示的条目数
     * @return
     */
    @Override
    public Page<Staff> findAllPage(Staff staff, int pageNum, int pageSize) {

        int totalRecord = staffDao.getTotalRecord();
        Page<Staff> page = new Page<Staff>(pageNum,pageSize,totalRecord);
        List<Staff> data = staffDao.findAllPage(page.getStartIndex(),page.getPageSize());
        page.setData(data);
        return page;
    }


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
