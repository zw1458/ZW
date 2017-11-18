package com.lanou3g.department.service.impl;

import com.lanou3g.department.dao.DepartmentDao;
import com.lanou3g.department.dao.impl.DepartmentDaoImpl;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;


    @Override
    public boolean save(Department department) {
        Department byDeptName = findDeptByDeptName(department.getDeptName());
        if (byDeptName == null) {

            return departmentDao.saveOrUpdate(department);
        }else {
            return false;
        }
    }


    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }


    @Override
    public boolean saveOrUpdate(Department department) {
        if (department.getDeptId().isEmpty()) {
            departmentDao.save(department);
        } else {
            departmentDao.update(department);
        }
        return true;
    }


    @Override
    public Department findDeptByDeptName(String deptName) {
        List<Department> deptByDeptName = departmentDao.findDeptByDeptName(deptName);
        for (Department department : deptByDeptName) {
            return department;
        }
        return null;
    }


    @Override
    public boolean update(Department department) {
        return false;
    }


    @Override
    public Department findById(Serializable id) {
        return null;
    }


    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
