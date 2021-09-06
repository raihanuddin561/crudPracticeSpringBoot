package com.spring.crudProject.repository;

import com.spring.crudProject.entity.Course;
import com.spring.crudProject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDba = Course.builder()
                .title("DBA")
                .credit(4)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Manik")
                .lastName("Mia")
                //.courses(Arrays.asList(courseDba,courseJava))
                .build();

        teacherRepository.save(teacher);
    }
@Test
    public void get_all_teacher(){
    List<Teacher> teachers = teacherRepository.findAll();
    System.out.println(teachers);
}
}