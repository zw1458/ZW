package com.lanou3g.department.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.department.service.impl.DepartmentServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("deptAction")
@Scope("prototype")
public class DeptAction extends BaseAction<Department, DepartmentService> {
    private String deptName, deptId;


    @Resource
    private DepartmentService departmentService;

    private Department department = getModel();
    private List<Department> deptList;




    public String findDept() {
        deptList = departmentService.findAll();
        return SUCCESS;
    }

    public String editDept() {
        if (departmentService.save(department)){
            return SUCCESS;
        }
        addFieldError("msg","部门名已存在");
        return ERROR;
    }


    public String validateEditDept(){
        if (StringUtils.isBlank(department.getDeptName())){
            addFieldError("error","请输入正确的名称");
        }
        return SUCCESS;
    }





    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {

        this.department = department;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
