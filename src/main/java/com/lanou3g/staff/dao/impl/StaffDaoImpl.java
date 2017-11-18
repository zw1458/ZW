package com.lanou3g.staff.dao.impl;

import com.lanou3g.page.util.impl.PageHibernateCallback;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Repository("staffDao")
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    @Override
    public boolean save(Staff staff) {
        if (staff.getStaffId() == 0) {
            getHibernateTemplate().save(staff);
        }
            getHibernateTemplate().saveOrUpdate(staff);
            return true;
    }

    @Override
    public Staff findStaffByLoginNameAndLoginPwd(Staff staff) {
        String hql = "from Staff T_STAFF where loginName = ? and loginPwd = ?";

        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql,staff.getLoginName(),staff.getLoginPwd());
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }


    @Override
    public boolean saveOrUpdate(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
        return true;
    }

    @Override
    public List<Post> getPostByDeptId(String deptId) {
        return null;
    }




    @Override
    public List<Staff> getStaffByPostId(String postId) {
        String sql = "from Staff T_STAFF where post.postId = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,postId);
        return list;
    }


    @Override
    public List<Staff> getStaffByDeptId(String deptId) {
        String sql = "from Staff T_STAFF where post.dept.deptId = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, deptId);
        return list;
    }

    @Override
    public List<Staff> getStaffByStaffName(String staffName) {
        String sql = "from Staff T_STAFF where staffName like ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, "%"+staffName+"%");
        return list;

    }






    @Override
    public Staff findAllByStaffId(int staffId) {

        Staff staff = getHibernateTemplate().get(Staff.class, staffId);
        return staff;
    }

    @Override
    public List<Staff> findAll() {
        String sql = "from Staff T_STAFF";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }




}
