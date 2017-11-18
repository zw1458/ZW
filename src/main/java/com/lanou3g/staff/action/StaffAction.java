package com.lanou3g.staff.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.page.domain.PageBean;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import com.lanou3g.util.CrmStringUtils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffService> {

    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService postService;


    private String loginName, loginPwd;
    private Staff staff = getModel();

    private int staffId;
    private String deptId;
    private String postId;
    private Staff staffIdList;



    private List<Staff> allList;
    private List<Department> departmentList;
    private List<Post> queryStaffPost;
    private List<Staff> staffByDeptIdList;





    //为了分页!



    //登录的方法
    public String login() {
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        Staff staff1 = staffService.login(staff);
        if (staff1 != null) {
            sessionPut("login", staff.getLoginName());
            return SUCCESS;
        }
        addFieldError("msg","请输入正确的用户名和密码");
        return INPUT;
    }


    //添加和修改的方法
    @SkipValidation
    public String addStaff() {
        staff.setPost(new Post(postId));

        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staffService.save(staff);
        List<Staff> all = staffService.findAll();
        applicationPut("allList",all);
        return SUCCESS;
    }


    //查询所有的员工(条件查询)
    @SkipValidation
    public String findStaff(){
        departmentList = departmentService.findAll();
        allList = staffService.queryForAll(staff.getStaffName(),postId,deptId);
        return SUCCESS;
    }


    //查询所有的部门
    @SkipValidation
    public String findAllDept(){
        departmentList = departmentService.findAll();
        return SUCCESS;
    }

    //查询所有的职位(通过部门的ID)
    @SkipValidation
    public String findAllPost(){
        queryStaffPost = postService.findPostByDeptId(deptId);
        return SUCCESS;
    }

    //通过员工的ID找到单个员工,进行编辑
    @SkipValidation
    public String editStaff(){
        departmentList = departmentService.findAll();
        staffIdList = staffService.findAllByStaffId(staff.getStaffId());
        return SUCCESS;
    }


    // 为了分页的方法!!!!!!














    /*
      以下全是弱智
     */


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public List<Staff> getAllList() {
        return allList;
    }

    public void setAllList(List<Staff> allList) {
        this.allList = allList;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }


    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<Post> getQueryStaffPost() {
        return queryStaffPost;
    }

    public void setQueryStaffPost(List<Post> queryStaffPost) {
        this.queryStaffPost = queryStaffPost;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Staff getStaffIdList() {
        return staffIdList;
    }

    public void setStaffIdList(Staff staffIdList) {
        this.staffIdList = staffIdList;
    }

    public List<Staff> getStaffByDeptIdList() {
        return staffByDeptIdList;
    }

    public void setStaffByDeptIdList(List<Staff> staffByDeptIdList) {
        this.staffByDeptIdList = staffByDeptIdList;
    }


}
