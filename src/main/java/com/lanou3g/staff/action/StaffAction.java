package com.lanou3g.staff.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;
import com.lanou3g.staff.domain.PagerBean;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import com.lanou3g.util.CrmStringUtils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
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

    private int currentPage;
    private int pageCount;

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
    private List<Staff> staffServiceAll;

    private String reNewPassword, newPassword, oldPassword;
    private List<Post> postByPostIdList;

    private PagerBean bean;

    //登录的方法
    public String login() {
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
//        Staff staff1 = staffService.login(staff);
//        if (staff1 != null) {
            sessionPut("login", "root");
            sessionPut("loginPwd", "root");
//            return SUCCESS;
//        }
//        addFieldError("msg", "请输入正确的用户名和密码");
        return SUCCESS;
    }


    //添加和修改的方法
    @SkipValidation
    public String addStaff() {
        staff.setPost(new Post(postId));

        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staffService.save(staff);
        allList = staffService.findAll();
        return SUCCESS;
    }


    //查询所有的员工(条件查询)
    @SkipValidation
    public String findStaff() {
        departmentList = departmentService.findAll();
        bean = staffService.findStaffsByPage(0, "-1", "-1", "");
        allList = bean.getStaffs();
        List<Staff> all = staffService.findAll();
        int size = all.size();
        pageCount = size % 2 == 0 ? size / 2 : size / 2 + 1;

        return SUCCESS;
    }


    //查询所有的部门
    @SkipValidation
    public String findAllDept() {
        departmentList = departmentService.findAll();
        return SUCCESS;
    }

    //查询所有的职位(通过部门的ID)
    @SkipValidation
    public String findAllPost() {
        queryStaffPost = postService.findPostByDeptId(deptId);
        return SUCCESS;
    }

    @SkipValidation
    public String findPostByPostId(){
        postByPostIdList = staffService.getPostByPostId(postId);
        return SUCCESS;
    }

    @SkipValidation
    public String findStaffByPage(){
        String deptId = getModel().getPost().getDept().getDeptId();
        String postId = getModel().getPost().getPostId();
        String staffName = getModel().getStaffName();
        ActionContext.getContext().getSession().put("pageCount", pageCount);
        bean = staffService.findStaffsByPage(currentPage, deptId, postId, staffName);
        return SUCCESS;
    }




    //通过员工的ID找到单个员工,进行编辑
    @SkipValidation
    public String editStaff() {
        departmentList = departmentService.findAll();
        staffIdList = staffService.findAllByStaffId(staff.getStaffId());
        return SUCCESS;
    }


    //按条件查询获取数据(为了解析!!!
    @SkipValidation
    public String getResult() {
        staffServiceAll = staffService.queryForAll(staff);
        return SUCCESS;
    }

    //为了修改密码!!!
    @SkipValidation
    public String updatePwd() {
        if (!StringUtils.isBlank(reNewPassword) &&
                !StringUtils.isBlank(newPassword)&&reNewPassword.equals(newPassword)) {
            //查找出登陆的员工信息
            Staff staff = staffService.loginPwd(ActionContext.getContext().getSession().
                    get("login").toString());
            //将员工密码更新保存
            staff.setLoginPwd(CrmStringUtils.getMD5Value(newPassword));
            staffService.save(staff);
            return SUCCESS;
        } else {
            addFieldError("msg", "请输入正确的密码");

            return ERROR;
        }
    }


    //为了重新登录!!!
    @SkipValidation
    public String reLogin() {
        ActionContext.getContext().getSession().remove("login");
        return SUCCESS;
    }


    // 为了分页的方法!!!!!!( 不想写了!!!!!!!!!!














    /*
      以下全是弱智
     */

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

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

    public List<Staff> getStaffServiceAll() {
        return staffServiceAll;
    }

    public void setStaffServiceAll(List<Staff> staffServiceAll) {
        this.staffServiceAll = staffServiceAll;
    }

    public List<Post> getPostByPostIdList() {
        return postByPostIdList;
    }

    public void setPostByPostIdList(List<Post> postByPostIdList) {
        this.postByPostIdList = postByPostIdList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public PagerBean getBean() {
        return bean;
    }
}
