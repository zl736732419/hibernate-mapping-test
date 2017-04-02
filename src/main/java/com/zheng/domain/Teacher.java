package com.zheng.domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Teacher {
    private Long id;
    private String name;

    private List<TeacherStudent> teacherStudents = Lists.newArrayList();

    // many2many
    private List<Student> students = Lists.newArrayList();

    public Teacher() {

    }

    public Teacher(String name) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof Teacher)) {
            return false;
        }

        Teacher other = (Teacher) obj;

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
