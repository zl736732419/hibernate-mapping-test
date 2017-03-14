package com.zheng.service.impl;

import com.zheng.domain.Department;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.DepartmentRepository;
import com.zheng.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    protected BaseRepository<Department> getRepository() {
        return departmentRepository;
    }
}
