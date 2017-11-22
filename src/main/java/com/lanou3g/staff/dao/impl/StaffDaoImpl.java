package com.lanou3g.staff.dao.impl;

import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.PagerBean;
import com.lanou3g.staff.domain.Staff;
import javafx.geometry.Pos;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql, staff.getLoginName(), staff.getLoginPwd());
        if (list.size() == 0) {
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
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, postId);
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
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, "%" + staffName + "%");
        return list;

    }

    @Override
    public List<Staff> getStaffByDeptIdAndStaffName(String deptId, String staffName) {
        String hql = "from Staff T_STAFF where post.dept.deptId = ? and staffName like ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql, deptId, "%" + staffName + "%");
        return list;
    }

    @Override
    public List<Staff> getStaffByThree(String deptId, String postId, String staffName) {
        String hql = "from Staff T_STAFF where post.dept.deptId = ? and post.postId = ? and staffName like ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql, deptId, postId, "%" + staffName + "%");
        return list;
    }

    @Override
    public List<Post> getPostByPostId(String postId) {
        String hql = "from Post T_POST where postId = ?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(hql, postId);
        return list;
    }

    @Override
    public PagerBean findStaffsByPage(int currentPage, String deptId, String postId, String staffName) {
        return getHibernateTemplate().execute(new HibernateCallback<PagerBean>() {
            @Override
            public PagerBean doInHibernate(Session session) throws HibernateException {

                StringBuilder builder = new StringBuilder("from Staff where 1 = 1 ");
                List<Object> values = new ArrayList<>();
                if (!"-1".equals(deptId)){
                    builder.append("and post.dept.deptId = ? ");
                    values.add(deptId);
                }
                if (!"-1".equals(postId)){
                    builder.append("and post.postId = ? ");
                    values.add(postId);
                }
                if (!"".equals(staffName)){
                    builder.append("and staffName like ?");
                    values.add("%" + staffName + "%");
                }
                Query countQuery = session.createQuery(builder.toString());

                Query query = session.createQuery(builder.toString());
                for (int i = 0; i < values.size(); i++) {
                    query.setParameter(i, values.get(i));
                    countQuery.setParameter(i, values.get(i));
                }
                int size = countQuery.list().size();
                int pageCount = size % 2 == 0 ? size / 2 : size / 2 + 1;
                // 设置分页
                query.setFirstResult(currentPage * 2);
                query.setMaxResults(2);
                PagerBean bean = new PagerBean();
                bean.setTotalSize(pageCount);
                bean.setStaffs(query.list());
                return bean;
            }
        });
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

    @Override
    public Staff loginPwd(String loginName) {
        String hql = "from Staff T_STAFF where loginName = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql, loginName);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
