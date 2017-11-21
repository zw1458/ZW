package com.lanou3g.staff.dao;

import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public interface StaffDao{

    boolean save(Staff staff);

    Staff findStaffByLoginNameAndLoginPwd(Staff staff);

    boolean saveOrUpdate(Staff staff);//没有用


    List<Post> getPostByDeptId(String deptId);

    Staff findAllByStaffId(int staffId);



    List<Staff> findAll();



    Staff loginPwd(String loginName);




    /*
       为了查询
     */
    List<Staff> getStaffByPostId(String postId);


    List<Staff> getStaffByDeptId(String deptId);


    List<Staff> getStaffByStaffName(String staffName);


    List<Staff> getStaffByDeptIdAndStaffName(String deptId,String staffName);

    List<Staff> getStaffByThree(String deptId,String postId,String staffName);

    /*
       为了分页
     */

    List<Post> getPostByPostId(String postId);


}
