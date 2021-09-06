package com.spring.crudProject.repository;

import com.spring.crudProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentName(String name);
    Department findByDepartmentNameIgnoreCase(String name);

    List<Department> findByActiveTrue();

    Department findByDepartmentIdAndActiveTrue(long id);
    //Department findByDepartmentIdAndActive(long id,boolean active);
}
