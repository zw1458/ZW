package com.lanou3g.page.util.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String hql ;
    private Object[] params;
    private int startIndex;
    private int pageSize;

    public PageHibernateCallback(String hql,int startIndex, int pageSize) {
        this.hql = hql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        // 1. 通过hql语句获取query对象
        Query queryObject = session.createQuery(hql);

        //2.分页
        queryObject.setFirstResult(startIndex);
        queryObject.setMaxResults(pageSize);
        //查询所有
        return queryObject.list();
    }









    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
