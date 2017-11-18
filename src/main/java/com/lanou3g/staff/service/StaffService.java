package com.lanou3g.staff.service;

import com.lanou3g.page.domain.PageBean;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService{

    Staff login(Staff staff);

    boolean save(Staff staff);


    List<Staff> findAll();


    List<Post> getPostByDeptId(String deptId);

    Staff findAllByStaffId(int staffId);


    //为了高级查询

    List<Staff> queryForAll(String staffName,String postId,String deptId);





    List<Staff> getStaffByPostId(String postId);


    List<Staff> getStaffByDeptId(String deptId);


    List<Staff> getStaffByStaffName(String staffName);

    /*
       为了分页
     */






}
