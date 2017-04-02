package com.zheng.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface BaseRepository<T> {
    
    void save(T t);

    void delete(Serializable id);
    void delete(T t);

    void update(T t);
    
    T get(Serializable id);

    void executeHQL(String hql, Object... args);

    T hqlOne(String hql, Object... args);

    List<T> hqlList(String hql, Object... args);

    void executeSQL(String sql, Object... args);

    Object sqlOne(String sql, Object... args);

    List<Map<String, Object>> sqlList(String sql, Object... args);

}
