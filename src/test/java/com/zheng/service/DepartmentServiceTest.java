package com.zheng.service;

import com.zheng.domain.Department;
import com.zheng.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public class DepartmentServiceTest extends BaseServiceTest {
    
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    
    @Test
    public void save() {
        Department department = new Department("男生公寓");
        departmentService.save(department);
    }
    
    @Test
    public void saveWithEmployees() {
        Department department = new Department("女生公寓");

        Employee gril = new Employee("小芳", 20);
        department.getEmployees().add(gril);
        gril = new Employee("如花", 21);
        department.getEmployees().add(gril);
        
        departmentService.save(department);
    }
    
    @Test
    public void get() {
        Department department = departmentService.get(3L);
        System.out.println(department);
        List<Employee> employees = department.getEmployees();
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }
    
    @Test
    public void saveDepartmentWithEmployee() {
        Department department = new Department("男生公寓");
        
        Employee employee = new Employee("小张", 20);
        employee.setDepartment(department);
        department.getEmployees().add(employee);
        
        employee = new Employee("小李", 20);
        department.getEmployees().add(employee);
        employee.setDepartment(department);
        
        departmentService.save(department);
    }
    
    @Test
    public void testDefaultBehavior() {
        Department department = new Department("女生公寓");
        Employee employee = employeeService.get(1L);
        department.getEmployees().add(employee);
        employee.setDepartment(department);
        employee = employeeService.get(2L);
        department.getEmployees().add(employee);
        employee.setDepartment(department);
        
        departmentService.save(department);
    }
    
    @Test
    public void delete() {
        // 报错，在没有指定delete-orphan/delete/all-delete-orphan的情况下
        // 要么把关系维护端指向自己，要么手动解除绑定
        departmentService.delete(6L);
    }
}
