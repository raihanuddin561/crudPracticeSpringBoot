package com.spring.crudProject.service.impl;

import com.spring.crudProject.entity.Department;
import com.spring.crudProject.exception.DepartmentNotFoundException;
import com.spring.crudProject.exception.ResourceNotFoundException;
import com.spring.crudProject.repository.DepartmentRepository;
import com.spring.crudProject.response.DepartmentRest;
import com.spring.crudProject.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentRest saveDepartment(Department department) {
        //department.setActive(true);
        DepartmentRest departmentRest = new DepartmentRest();
        Department department1=departmentRepository.save(department);
        BeanUtils.copyProperties(department1,departmentRest);
        return departmentRest;
    }

    @Override
    public List<DepartmentRest> fetchDepartmentList() throws DepartmentNotFoundException {
        List<Department> departmentList = departmentRepository.findByActiveTrue();
        if(departmentList==null){
            throw new DepartmentNotFoundException(
                    "no department found");
        }
        List<DepartmentRest> copyList = new ArrayList<>();
        departmentList.forEach(department -> {
            DepartmentRest departmentRest = new DepartmentRest();
            BeanUtils.copyProperties(department,departmentRest);
            copyList.add(departmentRest);
        });
        return copyList;
    }

    @Override
    public DepartmentRest getDepartmentById(Long id) throws DepartmentNotFoundException {
        Department department= departmentRepository.findByDepartmentIdAndActiveTrue(id);
        if(department==null){
            throw new DepartmentNotFoundException(
                    "Department not found for ID: "+id);
        }
        DepartmentRest rest = new DepartmentRest();
        BeanUtils.copyProperties(department,rest);
        return rest;
    }

    @Override
    public void deleteDepartment(Long id) throws DepartmentNotFoundException {
       Department department= departmentRepository.findByDepartmentIdAndActiveTrue(id);
       if(department==null){
          throw  new DepartmentNotFoundException(
                   "Department not found for ID: "+id);
       }
        //departmentRepository.deleteById(id);
        department.setActive(false);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentRest updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
       Department getDepartment= departmentRepository.findByDepartmentIdAndActiveTrue(id);
       if(getDepartment==null){
          throw new DepartmentNotFoundException(
                   "Department not found for ID: "+id);
       }
        if (department.getDepartmentName() != null) {
            getDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentAddress()!=null){
            getDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(department.getDepartmentCode()!=null){
            getDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        Department department1 = departmentRepository.save(getDepartment);
        DepartmentRest rest = new DepartmentRest();
        BeanUtils.copyProperties(department1,rest);
        return rest;
    }

    @Override
    public DepartmentRest getDepartmentByName(String name) throws DepartmentNotFoundException {
        Department department=departmentRepository.findByDepartmentNameIgnoreCase(name);
        if(department==null){
            throw new DepartmentNotFoundException("Department not found for dept name: "+name);
        }
        DepartmentRest rest = new DepartmentRest();
        BeanUtils.copyProperties(department,rest);
        return rest;
    }
}
