package com.spring.crudProject.service;

import com.spring.crudProject.entity.Department;
import com.spring.crudProject.exception.DepartmentNotFoundException;
import com.spring.crudProject.repository.DepartmentRepository;
import com.spring.crudProject.response.DepartmentRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Savar")
                .departmentCode("IT-01")
                .departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDeptName_thenDeptShouldFound() throws DepartmentNotFoundException {
        String departmentName="IT";
        DepartmentRest found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}