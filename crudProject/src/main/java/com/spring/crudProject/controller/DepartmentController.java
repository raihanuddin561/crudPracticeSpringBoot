package com.spring.crudProject.controller;

import com.spring.crudProject.entity.Department;
import com.spring.crudProject.exception.DepartmentNotFoundException;
import com.spring.crudProject.exception.ResourceNotFoundException;
import com.spring.crudProject.response.DepartmentRest;
import com.spring.crudProject.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER= LoggerFactory.getLogger(Department.class);
    @PostMapping()
    public ResponseEntity<DepartmentRest> saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside saveDepartment of department controller");
        return new ResponseEntity<DepartmentRest>(departmentService.saveDepartment(department),
                HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentRest>> getDepartmentList() throws DepartmentNotFoundException {
        LOGGER.info("inside getDepartmentList of department controller");
        return new ResponseEntity<>(departmentService.fetchDepartmentList(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentRest> getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("inside getDepartmentById of department controller");
        return new ResponseEntity<DepartmentRest>(departmentService.getDepartmentById(id),HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<DepartmentRest> getDepartmentByName(@PathVariable("name") String name) throws DepartmentNotFoundException {
        LOGGER.info("inside getDepartmentByName of department controller");
        return new ResponseEntity<DepartmentRest>(departmentService.getDepartmentByName(name),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentRest> updateDepartment(@PathVariable("id") Long id,
                                                        @RequestBody Department department) throws DepartmentNotFoundException {
        LOGGER.info("inside updateDepartment of department controller");
        return new ResponseEntity<DepartmentRest>(departmentService.updateDepartment(id,department),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("inside deleteDepartment of department controller");
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("Department has been deleted, ID: "+id,HttpStatus.OK);
    }


}
