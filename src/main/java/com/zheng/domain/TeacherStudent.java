package com.zheng.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Administrator on 2017/3/16.
 */
public class TeacherStudent {
    private Long id;
    private String subject;
    private Teacher teacher;
    private Student student;

    public TeacherStudent() {

    }

    public TeacherStudent(Teacher teacher, Student student, String subject) {
        this.teacher = teacher;
        this.student = student;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof TeacherStudent)) {
            return false;
        }

        TeacherStudent other = (TeacherStudent) obj;

        return new EqualsBuilder().append(this.subject, other.getSubject()).append(this.teacher.getId(), other.getTeacher().getId())
                .append(this.student.getId(), other.getStudent().getId()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.subject).append(this.teacher.getName()).append(this.student.getName()).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.subject).append(this.teacher.getName()).append(this.student.getName()).toString();
    }
}
