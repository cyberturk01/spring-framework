package org.yigit.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yigit.entity.Department;
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

    //Not Equal
    @Query("select e from  Employee  e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //Like/contains/startsWith/endsWith
    @Query("select e from  Employee  e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThen(int salary);

    //greater than
    @Query("SELECT e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThen(int salary);

    //Before
    @Query("SELECT e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHigherDateBefore(LocalDate date);

    //Between
    @Query("SELECT e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween2Salary(int salary1, int salary2 );

    //null
    @Query("SELECT e from Employee  e where e.email is null")
    List<Employee> getEmployeeEmailIsNull();

    //not null
    @Query("SELECT e from Employee  e where e.email is not null")
    List<Employee> getEmployeeEmailIsNotNull();

    //Sorting in asc
    @Query("SELECT e from Employee e order by e.salary ASC ")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in desc
    @Query("SELECT e from Employee e order by e.salary DESC ")
    List<Employee> getEmployeeSalaryOrderDesc();

    //nativeQuery sample
    //use table name as employees
    @Query(value = "SELECT * from employees where salary = ?1 ",nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("SELECT e from Employee e where e.salary= :salary")
    List<Employee> getEmployeeBySalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e Set e.email='admin@email.com' where e.id= :id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees Set email='admin@email.com' where id= :id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);



}
