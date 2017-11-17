package com.lanou3g.post.dao;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import javafx.geometry.Pos;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostDao {
    boolean save(Post post);

    List<Post> findAllPost(Post post);

    List<Department> findAllDept(Department department);

    void saveOrUpdate(Post post);

    List<Post> findPostByDeptId(String deptId);
}
