package com.lanou3g.post.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;
import com.lanou3g.post.service.impl.PostServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post,PostServiceImpl> {
    @Resource
    private PostService postService;
    @Resource
    private DepartmentService departmentService;
    private List<Post> allPost;
    private List<Department> departmentList;



    public String save(){
        postService.save(getModel());
        return SUCCESS;
    }

    public String findAllPost(){
        allPost = postService.findAllPost(getModel());
        return SUCCESS;
    }

    public String findAllDept(){
        departmentList = departmentService.findAll();
        return SUCCESS;
    }


   public String edit(){
       postService.edit(getModel());
       return SUCCESS;
   }




    public List<Post> getAllPost() {
        return allPost;
    }

    public void setAllPost(List<Post> allPost) {
        this.allPost = allPost;
    }




    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {

        this.departmentList = departmentList;
    }



}
