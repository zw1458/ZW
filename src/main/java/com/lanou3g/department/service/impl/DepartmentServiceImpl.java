package com.lanou3g.department.service.impl;

import com.lanou3g.department.dao.DepartmentDao;
import com.lanou3g.department.dao.impl.DepartmentDaoImpl;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;

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
       return departmentDao.saveOrUpdate(department);
    }



    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }


    @Override
    public boolean saveOrUpdate(Department department) {
        if (department.getDeptId().isEmpty()){
            departmentDao.save(department);
        }else {
            departmentDao.update(department);
        }
        return true;
    }





    @Override
    public boolean update(Department department) {
        return false;
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }


    @Override
    public Department findById(Serializable id) {
        return null;
    }


    @Override
    public List<Department> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }


    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
