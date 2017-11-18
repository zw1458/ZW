package com.lanou3g.staff.service.impl;

import com.lanou3g.page.domain.PageBean;
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
    public List<Staff> queryForAll(String staffName,String postId,String deptId) {
        if (!StringUtils.isBlank(staffName)){
            return staffDao.getStaffByStaffName(staffName);
        }else if (!StringUtils.isBlank(postId)&&!postId.equals("-1")){
            return staffDao.getStaffByPostId(postId);
        }else if (!StringUtils.isBlank(deptId)&&!deptId.equals("-1")){

            postId = null;
            return staffDao.getStaffByDeptId(deptId);
        }else {
            deptId = null;
            postId = null;
            return staffDao.findAll();
        }
//        return null;
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
