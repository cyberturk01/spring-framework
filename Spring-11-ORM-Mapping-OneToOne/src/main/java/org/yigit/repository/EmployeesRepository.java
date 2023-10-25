package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yigit.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
