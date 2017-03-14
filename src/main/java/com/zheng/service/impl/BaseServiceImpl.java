package com.zheng.service.impl;

import com.zheng.repository.BaseRepository;
import com.zheng.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected abstract BaseRepository<T> getRepository();
    
    @Override
    public void save(T t) {
        logger.debug("save or update object {}", t);
        getRepository().save(t);
    }

    @Override
    public void delete(Serializable id) {
        logger.debug("delete object which id is {}", id);
    }

    @Override
    public T get(Serializable id) {
        logger.debug("get an object which id is {} ", id);
        return getRepository().get(id);
    }
}