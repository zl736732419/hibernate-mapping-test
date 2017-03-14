package com.zheng.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Employee {
    private Long id;
    private String name;
    private Integer age;

    private Department department;

    public Employee() {

    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return new EqualsBuilder().append(this.name, other.name).append(this.age, other.age).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.name).append(this.age).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.name).append(this.age).toString();
    }
}
