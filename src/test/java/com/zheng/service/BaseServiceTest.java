package com.zheng.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml", 
		"/applicationContext-ds.xml",
        "/applicationContext-app.xml","/applicationContext-tx.xml"})
public class BaseServiceTest {
}
