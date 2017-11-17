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






    /*
       为了查询
     */
    List<Staff> getStaffByPostId(String postId);


    List<Staff> getStaffByDeptId(String deptId);


    List<Staff> getStaffByStaffName(String staffName);





    /*
       为了分页
     */


    /**
     * 获取到的数据
     * @return
     */
    int getTotalRecord();

    /**
     *  获取到数据 -- 带分页的参数的
     * @param startIndex    开始索引
     * @param pageSize      每页显示的记录数
     * @return
     */
    List<Staff> findAllPage(
                       int startIndex,
                       int pageSize);

}
