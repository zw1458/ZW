package com.lanou3g.staff.service;

import com.lanou3g.base.BaseDao;
import com.lanou3g.page.domain.Page;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.domain.Staff;

import java.io.Serializable;
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



    List<Staff> getStaffByPostId(String postId);


    List<Staff> getStaffByDeptId(String deptId);


    List<Staff> getStaffByStaffName(String staffName);

    /*
       为了分页
     */

    /**
     * 查询所有   分页查询
     * @param staff
     * @param pageNum     当前的页
     * @param pageSize    每页显示的条目数
     * @return
     */
    Page<Staff> findAllPage(Staff staff,int pageNum,int pageSize);




}
