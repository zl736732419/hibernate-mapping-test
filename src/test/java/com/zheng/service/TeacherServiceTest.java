package com.zheng.service;

import com.zheng.domain.Student;
import com.zheng.domain.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/16.
 */
public class TeacherServiceTest extends BaseServiceTest{
    
    @Autowired
    private TeacherService teacherService;
    
    @Test
    public void save() {
        Student student = new Student("小张");
        Teacher teacher = new Teacher("张老师");
        teacher.getStudents().add(student);
        student = new Student("小红");
        teacher.getStudents().add(student);
        
        teacherService.save(teacher);
    }
    
    @Test
    public void delete() {
        teacherService.delete(2L);
    }
    
    @Test
    public void deleteStudent() {
        Teacher teacher = teacherService.get(6L);
        for(Student student : teacher.getStudents()) {
            if(student.getId() == 13L) {
                teacher.getStudents().remove(student);
                break;
            }
        }
        
        teacherService.delete(teacher);
    }
    
    @Test
    public void updateTeacher() {
        Teacher teacher = teacherService.get(12L);
        teacher.getTeacherStudents().remove(0); //手动解绑
        teacherService.update(teacher);
    }
    
}
