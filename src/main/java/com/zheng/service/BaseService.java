package com.zheng.service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface BaseService<T> {
    void save(T t);
    void delete(Serializable id);
    void delete(T t);
    void update(T t);
    T get(Serializable id);
}
