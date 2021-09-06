package com.spring.crudProject.controller;

import com.spring.crudProject.entity.Course;
import com.spring.crudProject.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(Course.class);
    @Autowired
    private CourseService courseService;

    @PostMapping()
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course){
        logger.info("inside course controller and save course method");
        return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

}
