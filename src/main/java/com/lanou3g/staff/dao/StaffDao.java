package com.lanou3g.staff.dao;

import com.lanou3g.base.BaseDao;
import com.lanou3g.staff.domain.Staff;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public interface StaffDao extends BaseDao<Staff> {


    @Override
    boolean save(Staff staff);

    @Override
    boolean delete(Staff staff);

    @Override
    List<Staff> findAll();

    @Override
    Staff findById(Serializable id);

    @Override
    boolean update(Staff staff);

    @Override
    boolean saveOrUpdate(Staff staff);

    @Override
    List<Staff> findAll(String condition, Object... params);

    @Override
    int getTotalrecord(String condition, Object[] params);
}
