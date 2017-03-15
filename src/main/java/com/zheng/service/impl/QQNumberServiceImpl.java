package com.zheng.service.impl;

import com.zheng.domain.QQNumber;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.QQNumberRepository;
import com.zheng.service.QQNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
public class QQNumberServiceImpl extends BaseServiceImpl<QQNumber> implements QQNumberService {
    
    @Autowired
    private QQNumberRepository qqNumberRepository;
    
    @Override
    protected BaseRepository<QQNumber> getRepository() {
        return qqNumberRepository;
    }
}
