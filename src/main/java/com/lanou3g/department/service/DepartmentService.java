package com.lanou3g.department.service;

import com.lanou3g.base.BaseDao;
import com.lanou3g.department.domain.Department;

/**
 * Created by dllo on 17/11/11.
 */
public interface DepartmentService extends BaseDao<Department> {
    boolean save(Department department);

}
