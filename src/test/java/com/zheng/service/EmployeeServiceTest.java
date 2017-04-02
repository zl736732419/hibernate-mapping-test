package com.zheng.service;

import com.zheng.domain.Department;
import com.zheng.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/15.
 */
public class EmployeeServiceTest extends BaseServiceTest {
    @Autowired
    private EmployeeService employeeService;
    
    @Test
    public void save() {
        Department department = new Department("女生公寓");
        Employee gril = new Employee("小芳", 20);
        gril.setDepartment(department);
        employeeService.save(gril);

        gril = new Employee("如花", 21);
        gril.setDepartment(department);
        employeeService.save(gril);
    }
    
    @Test
    public void delete() {
        employeeService.delete(12L);
    }
}
