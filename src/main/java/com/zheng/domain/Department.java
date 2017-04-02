package com.zheng.domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * one many
 * Created by Administrator on 2017/3/14.
 */
public class Department {
    private Long id;
    private String name;

    private List<Employee> employees = Lists.newArrayList();
    
    public Department() {
    }
    
    public Department(String name) {
        this.name = name;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj) {
            return false;
        }

        if(!(obj instanceof Department)) {
            return false;
        }

        Department other = (Department) obj;
        return new EqualsBuilder().append(this.name, other.getName()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.name).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.name).append("employee size", this.employees.size()).build();
    }
}
