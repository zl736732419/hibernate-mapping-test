package com.zheng.service;

import com.zheng.domain.Student;
import com.zheng.domain.Teacher;
import com.zheng.domain.TeacherStudent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/16.
 */
public class StudentServiceTest extends BaseServiceTest {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        Teacher teacher = new Teacher("张老师");
        Student student = new Student("小红");
        student.getTeachers().add(teacher);
        teacher.getStudents().add(student);
        studentService.save(student);

//        student = new Student("小刚");
//        student.getTeachers().add(teacher);
//        teacher.getStudents().add(student);
//        studentService.save(student);

    }

    @Test
    public void saveStudent() {
        Teacher teacher = teacherService.get(13L);
        Student student = new Student("小红");
        student.getTeachers().add(teacher);
        teacher.getStudents().add(student);
//        studentService.save(student);
        teacherService.update(teacher);
    }

    @Test
    public void unbindTeacher() {
        Teacher teacher = teacherService.get(13L);
        Student student = studentService.get(6L);
        student.getTeachers().remove(teacher);
        studentService.update(student);
    }
    
    @Test
    public void unbindStudent() {
        Teacher teacher = teacherService.get(13L);
        teacher.getStudents().remove(0);
        teacherService.update(teacher);
    }

    @Test
    public void delete() {
        Student student = studentService.get(14L);
        for (Teacher teacher : student.getTeachers()) {
            if ("张老师".equals(teacher.getName())) {
                student.getTeachers().remove(teacher);
                break;
            }
        }
        studentService.update(student);
    }


    @Test
    public void saveWithOne2Many() {
        Teacher teacher = new Teacher("张老师");
        Student student = new Student("小红");
        TeacherStudent teacherStudent = new TeacherStudent(teacher, student, "语文");
        student.getTeacherStudents().add(teacherStudent);
        studentService.save(student);

//        student = new Student("小刚");
//        teacherStudent = new TeacherStudent(teacher, student, "语文");
//        student.getTeacherStudents().add(teacherStudent);
//        studentService.save(student);
    }

    @Test
    public void saveOne() {
        Teacher teacher = new Teacher("李老师");
        Student student = studentService.get(20L);
        TeacherStudent teacherStudent = new TeacherStudent(teacher, student, "数学");
        student.getTeacherStudents().add(teacherStudent);
        studentService.update(student);
    }

    @Test
    public void findWithOne2Many() {
        Student student = studentService.get(20L);
        System.out.println(student.getTeacherStudents().size());
        for (TeacherStudent teacherStudent : student.getTeacherStudents()) {
            System.out.println(teacherStudent);
        }
    }

    @Test
    public void unbindWithOne2Many() {
        Student student = studentService.get(20L);
        for (TeacherStudent teacherStudent : student.getTeacherStudents()) {
            if ("张老师".equals(teacherStudent.getTeacher().getName())) {
                student.getTeacherStudents().remove(teacherStudent);
                break;
            }
        }

        studentService.update(student);
    }

    @Test
    public void deleteWithOne2Many() {
        Student student = studentService.get(23L);
        for (TeacherStudent teacherStudent : student.getTeacherStudents()) {
            if ("张老师".equals(teacherStudent.getTeacher().getName())) { //手动解绑inverse=true
                student.getTeacherStudents().remove(teacherStudent);
                break;
            }
        }

        studentService.delete(student);
    }
}
