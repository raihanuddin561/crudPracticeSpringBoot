package com.spring.crudProject.repository;

import com.spring.crudProject.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                //.departmentId(1L)
                .departmentName("Finance")
                .departmentAddress("Savar")
                .departmentCode("SE-01")
                .build();
        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Findy by Name of department")
    public void whenValidId_thenDepartmentShouldFound(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Finance");
    }
}