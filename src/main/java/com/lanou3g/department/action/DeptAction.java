package com.lanou3g.department.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.department.service.impl.DepartmentServiceImpl;
import com.lanou3g.page.domain.PageBean;
import com.opensymphony.xwork2.ActionContext;
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

    private List<Department> deptList;




    //查询所有的部门
    public String findDept() {
        deptList = departmentService.findAll();
        return SUCCESS;
    }

    //添加和编辑的方法,只是名字取得有点垃圾
    public String editDept() {
        if (departmentService.save(getModel())){
            return SUCCESS;
        }
        addFieldError("msg","部门名已存在");
        return ERROR;
    }


    //为了验证!!(部门名不能为空的判断!!!!!!
    public void validateEditDept(){
        if (StringUtils.isBlank(getModel().getDeptName())){
            addFieldError("error","部门名不能为空");
        }
    }






//为了分页!!!!!!!!!!!!!

    //分页 pageNum, pageSize 并设置默认值
    private int pageNum = 1;

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    private int pageSize = 5;
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String findAllDeptsForPage(){
        PageBean<Department> forPage = departmentService.findDeptForPage(getModel(), pageNum, pageSize);
        ActionContext.getContext().put("pageBean",forPage);
        return SUCCESS;
    }






    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
