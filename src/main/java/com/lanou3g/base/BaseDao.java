package com.lanou3g.base;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface BaseDao<T> {


    boolean save(T t);


    boolean update(T t);


    boolean delete(T t);

    boolean saveOrUpdate(T t);

    /**
     * 通过id查询
     */
    T findById(java.io.Serializable id);
    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 带有条件查询
     * @param condition 条件
     * @param params   参数
     * @return
     */
    List<T> findAll(String condition, Object...params);
//
//    T find(String loginName, String loginPwd);

    /**
     * 查询总记录数
     * @param condition
     * @param params
     * @return
     */
//    int getTotalRecord();
    int getTotalrecord(String condition,Object[] params);

    /**
     * 获取到数据  带分页的参数的
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
//    List<T> findAll(String condition, Object[] params,int startIndex,int pageSize);
}
