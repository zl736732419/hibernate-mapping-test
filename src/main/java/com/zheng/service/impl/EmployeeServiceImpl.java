package com.zheng.service.impl;

import com.zheng.domain.Employee;
import com.zheng.repository.BaseRepository;
import com.zheng.repository.EmployeeRepository;
import com.zheng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    protected BaseRepository<Employee> getRepository() {
        return employeeRepository;
    }
}
