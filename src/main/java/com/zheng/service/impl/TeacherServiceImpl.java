package com.zheng.service.impl;

import com.zheng.domain.Teacher;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.TeacherRepository;
import com.zheng.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    protected BaseRepository<Teacher> getRepository() {
        return teacherRepository;
    }
}
