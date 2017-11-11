package com.lanou3g.staff.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import com.lanou3g.staff.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
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
public class StaffAction extends BaseAction<Staff, StaffServiceImpl> {

    private String loginName, loginPwd;
    @Resource
    private StaffService staffService;
    private Staff staff = getModel();
    private List<Staff> allList;
    private String staffId;


    public String login() {
//        sessionPut(LOGIN_KEY,);
        Staff staff1 = staffService.login(staff);
        if (staff1 != null) {
            sessionPut("login", staff.getLoginName());
            return SUCCESS;
        }
        addFieldError("msg","请输入正确的用户名和密码");
        return INPUT;

    }


    public String addStaff() {
        boolean saveList = staffService.save(staff);
        List<Staff> all = staffService.findAll();
        applicationPut("allList",all);
        return SUCCESS;
    }

    @SkipValidation
    public String findStaff(){
        allList = staffService.findAll();
        applicationPut("allList",allList);
        return SUCCESS;
    }



    public String saveOrUpdate(){
        List<Staff> list = staffService.findAll();
        staffService.saveOrUpdate(staff);
        applicationPut("allList",list);
        return SUCCESS;

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

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }
}
