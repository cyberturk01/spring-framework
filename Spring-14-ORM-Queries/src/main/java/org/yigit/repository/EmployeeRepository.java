package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yigit.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    //JPQL Java Persistence Query Language
    //Use Class name not table name in Employee

    @Query("Select e FROM Employee e WHERE e.email='gmariner18@noaa.gov'")
    Employee getEmployeeDetail();

    @Query("SELECT s.salary From Employee s WHERE s.email='gmariner18@noaa.gov'")
    Integer getEmployeeSalary();

    @Query("Select e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e where e.email=?1 and e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, int salary);
}
