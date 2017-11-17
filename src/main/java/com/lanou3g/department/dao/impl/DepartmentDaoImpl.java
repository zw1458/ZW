package com.lanou3g.department.dao.impl;

import com.lanou3g.department.dao.DepartmentDao;
import com.lanou3g.department.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<Department> findAllDept(Department department) {
        return null;
    }

    @Override
    public boolean save(Department department) {
        getHibernateTemplate().save(department);
        return true;
    }


    @Override
    public List<Department> findAll() {
        List<Department> list = (List<Department>) getHibernateTemplate().find("from Department T_DEPT");
        return list;
    }


    @Override
    public boolean saveOrUpdate(Department department) {
        if (department.getDeptId().isEmpty()) {
            getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
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
}
