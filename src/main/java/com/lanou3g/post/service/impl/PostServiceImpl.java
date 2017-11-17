package com.lanou3g.post.service.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.dao.PostDao;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;
    @Override
    public boolean save(Post post) {
        postDao.save(post);
        return true;
    }

    @Override
    public List<Post> findAllPost(Post post) {
        return postDao.findAllPost(post);
    }

    @Override
    public List<Department> findAllDept(Department department) {
        return postDao.findAllDept(department);
    }

    @Override
    public void edit(Post post) {
        postDao.saveOrUpdate(post);
    }

    @Override
    public List<Post> findPostByDeptId(String deptId) {
        return postDao.findPostByDeptId(deptId);
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
