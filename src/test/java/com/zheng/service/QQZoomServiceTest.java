package com.zheng.service;

import com.zheng.domain.QQNumber;
import com.zheng.domain.QQZoom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/15.
 */
public class QQZoomServiceTest extends BaseServiceTest {
    
    @Autowired
    private QQZoomService qqZoomService;
    
    @Test
    public void save() {
        QQZoom qqZoom = new QQZoom("千本樱");
        QQNumber qqNumber = new QQNumber("123456");
        
        qqZoom.setQqNumber(qqNumber);
        qqNumber.setQqZoom(qqZoom);
        
        qqZoomService.save(qqZoom);
    }
    
    @Test
    public void delete() {
        qqZoomService.delete(2L);
    }
}
