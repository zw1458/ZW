package com.lanou3g.staff.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import com.lanou3g.staff.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
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



    public String login() {
//        sessionPut(LOGIN_KEY,);
        List<Staff> all = staffService.findAll();
        for (Staff staff1 : all) {
            if (staff1.getLoginName().equals(staff.getLoginName()) && staff1.getLoginPwd().equals(staff.getLoginPwd())) {
                return SUCCESS;
            }
            break;
        }
        return INPUT;
    }

    public String addStaff(){
        staffService.save(staff);
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
}
