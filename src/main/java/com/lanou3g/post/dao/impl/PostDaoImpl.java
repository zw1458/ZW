package com.lanou3g.post.dao.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.page.utils.PageHibernateCallback;
import com.lanou3g.post.dao.PostDao;
import com.lanou3g.post.domain.Post;
import javafx.geometry.Pos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Repository("postDao")
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    @Override
    public boolean save(Post post) {
        getHibernateTemplate().save(post);

        return true;
    }

    @Override
    public List<Post> findAllPost(Post post) {
        List<Post> list = (List<Post>) getHibernateTemplate().find("from Post T_POST");
        return list;
    }

    @Override
    public List<Department> findAllDept(Department department) {
        List<Department> deptList = (List<Department>) getHibernateTemplate().find("from Department T_DEPT");
        return deptList;
    }

    @Override
    public void saveOrUpdate(Post post) {

        if (StringUtils.isBlank(post.getPostId())){
            post.setPostId(null);
            getHibernateTemplate().save(post);
        }
        getHibernateTemplate().saveOrUpdate(post);
    }

    @Override
    public List<Post> findPostByDeptId(String deptId) {
        String sql = "from Post T_POST where dept.deptId = ?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql,deptId);
        return list;
    }

    @Override
    public int getTotalRecord() {
        String hql = "select count(c) from Post c where 1=1";
        List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
        if (list!=null){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Post> findDeptForPage(int startIndex, int pageSize) {
        String hql = "from Department where 1 = 1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Post>(hql,startIndex,pageSize));
    }


}
