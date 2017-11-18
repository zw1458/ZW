package com.lanou3g.department.service;

import com.lanou3g.base.BaseDao;
import com.lanou3g.department.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DepartmentService extends BaseDao<Department> {
    boolean save(Department department);

    Department findDeptByDeptName(String deptName);
}
