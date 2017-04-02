package com.zheng.service.impl;

import com.zheng.domain.Student;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.StudentRepository;
import com.zheng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    protected BaseRepository<Student> getRepository() {
        return studentRepository;
    }
}
