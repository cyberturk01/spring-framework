package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
