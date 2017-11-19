package com.lanou3g.staff.service.impl;

import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
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
    public List<Staff> queryForAll(Staff staff) {
        if (!StringUtils.isBlank(staff.getStaffName())){
            return staffDao.getStaffByStaffName(staff.getStaffName());
        }else if (!StringUtils.isBlank(staff.getPost().getPostId())&&!staff.getPost().getPostId().equals("-1")){
            return staffDao.getStaffByPostId(staff.getPost().getPostId());
        }else if (!StringUtils.isBlank(staff.getPost().getDept().getDeptId())&&!staff.getPost().getDept().getDeptId().equals("-1")){
            staff.getPost().setPostId(null);
            return staffDao.getStaffByDeptId(staff.getPost().getDept().getDeptId());
        }else {
            staff.getPost().getDept().setDeptId(null);
            staff.getPost().setPostId(null);
            return staffDao.findAll();
        }
//        return null;
    }

    @Override
    public Staff LoginPwd(String loginName) {
        return staffDao.LoginPwd(loginName);
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




    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
