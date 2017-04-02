package com.zheng.domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Student {
    private Long id;
    private String name;

    private List<TeacherStudent> teacherStudents = Lists.newArrayList();
    // many2many    
    private List<Teacher> teachers = Lists.newArrayList();

    public Student() {

    }

    public Student(String name) {
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

    public List<TeacherStudent> getTeacherStudents() {
        return teacherStudents;
    }

    public void setTeacherStudents(List<TeacherStudent> teacherStudents) {
        this.teacherStudents = teacherStudents;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return new EqualsBuilder().append(this.name, other.getName()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.name).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.name).toString();
    }

}
