package com.spring.crudProject.service;

import com.spring.crudProject.entity.Department;
import com.spring.crudProject.exception.DepartmentNotFoundException;
import com.spring.crudProject.response.DepartmentRest;

import java.util.List;

public interface DepartmentService {
    DepartmentRest saveDepartment(Department department);

    List<DepartmentRest> fetchDepartmentList() throws DepartmentNotFoundException;

    DepartmentRest getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartment(Long id) throws DepartmentNotFoundException;

    DepartmentRest updateDepartment(Long id, Department department) throws DepartmentNotFoundException;

    DepartmentRest getDepartmentByName(String name) throws DepartmentNotFoundException;
}
