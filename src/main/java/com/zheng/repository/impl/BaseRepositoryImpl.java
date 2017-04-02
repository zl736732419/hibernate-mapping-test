package com.zheng.repository.impl;

import com.zheng.repository.BaseRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public abstract class BaseRepositoryImpl<T> extends HibernateDaoSupport implements BaseRepository<T> {
    
    private Class<T> entityCls;
    
    public BaseRepositoryImpl() {
        Type type = this.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            entityCls = (Class<T>) pt.getActualTypeArguments()[0];
        }
        
    }
    
    protected Session getSession() {
        return this.getSessionFactory().getCurrentSession();
    }
    
    @Autowired
    public void setSessionFactory1(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    public void save(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    @Override
    public void delete(Serializable id) {
        this.getHibernateTemplate().delete(get(id));
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T get(Serializable id) {
        return this.getHibernateTemplate().load(entityCls, id);
    }

    @Override
    public void executeHQL(String hql, Object... args) {
        Query query = this.getSession().createQuery(hql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        
        query.executeUpdate();
    }

    @Override
    public T hqlOne(String hql, Object... args) {
        Query query = this.getSession().createQuery(hql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> hqlList(String hql, Object... args) {
        Query query = this.getSession().createQuery(hql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        return query.list();
    }
    
    @Override
    public void executeSQL(String sql, Object... args) {
        SQLQuery query = this.getSession().createSQLQuery(sql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        query.executeUpdate();
    }

    @Override
    public Object sqlOne(String sql, Object... args) {
        SQLQuery query = this.getSession().createSQLQuery(sql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        
        return query.uniqueResult();
    }

    @Override
    public List<Map<String, Object>> sqlList(String sql, Object... args) {
        SQLQuery query = this.getSession().createSQLQuery(sql);
        if(null != args && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                query.setParameter((i+1), args[i]);
            }
        }
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        
        return query.list();
    }
}
