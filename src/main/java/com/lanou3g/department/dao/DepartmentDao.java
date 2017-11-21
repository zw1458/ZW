package com.lanou3g.department.dao;

import com.lanou3g.base.BaseDao;
import com.lanou3g.department.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DepartmentDao extends BaseDao<Department> {

    List<Department> findAllDept(Department department);

    boolean save(Department department);

    @Override
    List<Department> findAll();

    List<Department> findDeptByDeptName(String deptName);

    int getTotalRecord();

    List<Department> findDeptForPage(int startIndex, int pageSize);
}
