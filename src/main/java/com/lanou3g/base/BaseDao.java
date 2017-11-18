package com.lanou3g.base;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface BaseDao<T> {


    boolean save(T t);


    boolean update(T t);




    boolean saveOrUpdate(T t);

    /**
     * 通过id查询
     */
    T findById(java.io.Serializable id);
    /**
     * 查询所有
     */
    List<T> findAll();


//    List<T> findAll(String condition, Object[] params,int startIndex,int pageSize);
}
