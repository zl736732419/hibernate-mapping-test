package com.zheng.service.impl;

import com.zheng.domain.QQZoom;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.QQZoomRepository;
import com.zheng.service.QQZoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
public class QQZoomServiceImpl extends BaseServiceImpl<QQZoom> implements QQZoomService {
    
    @Autowired
    private QQZoomRepository qqZoomRepository;
    
    @Override
    protected BaseRepository<QQZoom> getRepository() {
        return qqZoomRepository;
    }
}
