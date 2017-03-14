package com.zheng.service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface BaseService<T> {
    void save(T t);
    void delete(Serializable id);
    T get(Serializable id);
}
