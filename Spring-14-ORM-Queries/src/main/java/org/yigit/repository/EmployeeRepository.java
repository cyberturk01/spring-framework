package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yigit.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Display all employees with email address
    List<Employee> findByEmail(String email);
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName, String email);
    List<Employee> findByFirstNameIsNot(String firstName);
    List<Employee> findByLastNameIsStartingWith(String lastName);
    List<Employee> findBySalaryIsGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);
    List<Employee> findByEmailIsNull();
}
