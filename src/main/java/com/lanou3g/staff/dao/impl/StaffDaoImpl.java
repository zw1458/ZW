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
//        Object[] value = {staff.getLoginName(),staff.getLoginPwd()};
//        Staff staff1 = getHibernateTemplate().get(Staff.class, value);
//        return staff1;
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

    /**
     * 获取到的数据
     * @return
     */
    @Override
    public int getTotalRecord() {
        String hql = "select count(c) from Staff c where 1=1" ;
        List<Long> find = (List<Long>) getHibernateTemplate().find(hql);
        if (find!=null){
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 获取到数据 -- 带分页的参数的
     * @param startIndex    开始索引
     * @param pageSize      每页显示的记录数
     * @return
     */
    @Override
    public List<Staff> findAllPage(int startIndex, int pageSize) {
        String hql = "from Staff where 1=1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Staff>(hql,startIndex,pageSize));
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
