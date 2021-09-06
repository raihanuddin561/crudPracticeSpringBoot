package com.spring.crudProject.repository;

import com.spring.crudProject.entity.Course;
import com.spring.crudProject.entity.Student;
import com.spring.crudProject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void getAllCourse(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }


    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Raihan")
                .lastName("Uddin")
                .build();

        Course course = Course.builder()
                .title("Spring")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);

    }

    @Test
    public void getAllCoursePaginated(){
        Pageable firstPage = PageRequest.of(0,3);
        Pageable secondPage = PageRequest.of(1,3);
        List<Course> courseList = courseRepository.findAll(firstPage).getContent();
        List<Course> courseList2 = courseRepository.findAll(secondPage).getContent();
        Long totalElement = courseRepository.findAll(firstPage).getTotalElements();
        int totalPage = courseRepository.findAll(firstPage).getTotalPages();

        System.out.println("Total elements : "+totalElement);
        System.out.println("Total pages: "+totalPage);
        System.out.println("Courses: "+courseList);
        System.out.println("Courses 2nd page: "+courseList2);
    }

    @Test
    public void saveStuendTeacherCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Ashraf")
                .lastName("Ali")
                .build();
        Student student = Student.builder()
                .firstName("Jahid")
                .lastName("Hasan")
                .email("jahid@gmail.com")
                .build();
        Course course = Course.builder()
                .title("Algorithm")
                .credit(5)
                .teacher(teacher)
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }

}