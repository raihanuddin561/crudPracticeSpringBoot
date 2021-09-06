package com.spring.crudProject.repository;

import com.spring.crudProject.entity.Guardian;
import com.spring.crudProject.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Rana")
                .lastName("Ahmed")
                .email("rana@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Rahim Ahmed")
                .email("rahim@gmail.com")
                .mobile("01234566")
                .build();
        Student student = Student.builder()
                .email("rakib@gmail.com")
                .firstName("Rakib")
                .lastName("Ahmed")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
    @Test
    public void getStudentsByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Rakib");
        System.out.println(studentList);
    }

    @Test
    public void getStudentsByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("Ra");
        System.out.println(studentList);
    }
    @Test
    public void getStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Rahim Ahmed");
        System.out.println("Guardian name: "+studentList);
    }
}