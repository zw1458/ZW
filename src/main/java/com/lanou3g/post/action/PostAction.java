package com.lanou3g.post.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DepartmentService;
import com.lanou3g.page.domain.PageBean;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;
import com.lanou3g.post.service.impl.PostServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post,PostService
        > {
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
//       if (postService.save(getModel())){
//           return SUCCESS;
//       }
//       addFieldError("msg","部门名已存在");
//       return ERROR;
   }





//
//   public String validateEdit(){
//       if (StringUtils.isBlank(getModel().getPostName())){
//           addFieldError("error","部门名不能为空");
//       }
//       return SUCCESS;
//   }


    //分页 pageNum, pageSize 并设置默认值
    private int pageNum = 1;

    public void setPageNum(int pageNum
    ) {
        this.pageNum = pageNum;
    }

    private int pageSize = 5;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



    public String findAllPostForPage(){
        PageBean<Post> forPage = postService.findDeptForPage(getModel(), pageNum, pageSize);
        ActionContext.getContext().put("pageBean",forPage);
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
