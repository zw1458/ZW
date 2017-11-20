package com.lanou3g.department.dao.impl;

import com.lanou3g.department.dao.DepartmentDao;
import com.lanou3g.department.domain.Department;
import com.lanou3g.page.utils.PageHibernateCallback;
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
    public List<Department> findDeptByDeptName(String deptName) {
        String hql = "from Department T_DEPT where deptName = ?";
        List<Department> list = (List<Department>) getHibernateTemplate().find(hql, deptName);
        return list;
    }

    @Override
    public int getTotalRecord() {
        String hql = "select count(c) from Department c where 1=1";
        List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
        if (list!=null){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> findDeptForPage(int startIndex, int pageSize) {
        String hql = "from Department where 1 = 1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Department>(hql,startIndex,pageSize));
    }


    @Override
    public boolean update(Department department) {
        return false;
    }



    @Override
    public Department findById(Serializable id) {
        return null;
    }



}
