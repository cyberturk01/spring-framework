package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.entity.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //Display all departments in the health division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);
    List<Department> findDistinctTop3ByDivisionContaining(String department);
}
