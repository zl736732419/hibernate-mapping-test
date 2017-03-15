package com.zheng.service;

import com.zheng.domain.QQNumber;
import com.zheng.domain.QQZoom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/15.
 */
public class QQNumberServiceTest extends BaseServiceTest {
    
    @Autowired
    private QQNumberService qqNumberService;

    @Test
    public void save() {
        QQNumber qqNumber = new QQNumber("123456");
        QQZoom qqZoom = new QQZoom("千本樱");

        qqNumber.setQqZoom(qqZoom);
        qqZoom.setQqNumber(qqNumber);

        qqNumberService.save(qqNumber);
    }

    @Test
    public void delete() {
        qqNumberService.delete(3L);
    }
    
}
