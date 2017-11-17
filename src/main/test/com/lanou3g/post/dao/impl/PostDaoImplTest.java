package com.lanou3g.post.dao.impl;

import com.lanou3g.post.dao.PostDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class PostDaoImplTest {

    @Resource
    private PostDao postDao;

    @Test
    public void test(){
        System.out.println(postDao.findPostByDeptId("2c90907e5fb344fc015fb3456f5f0000"));
    }
}