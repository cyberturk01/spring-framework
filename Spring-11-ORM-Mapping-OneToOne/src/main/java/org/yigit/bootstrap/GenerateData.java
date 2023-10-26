package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.entity.Department;
import org.yigit.entity.Employee;
import org.yigit.enums.Gender;
import org.yigit.repository.DepartmentsRepository;
import org.yigit.repository.EmployeesRepository;

import java.math.BigInteger;
import java.time.LocalDate;

@Component
public class GenerateData implements CommandLineRunner {

    private final DepartmentsRepository departmentsRepository;
    private final EmployeesRepository employeesRepository;

    public GenerateData(DepartmentsRepository departmentsRepository, EmployeesRepository employeesRepository) {
        this.departmentsRepository = departmentsRepository;
        this.employeesRepository = employeesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department("Clothing","Home");
        Department department2 = new Department("Grocery","Home");
        Department department3 = new Department("Handball","Sport");
        Department department4 = new Department("Soccer","Sport");

        Employee employee1 = new Employee("Berrie","Manueau","bmanueau0@dion.ne.jp", LocalDate.of(2006,4,20), Gender.FEMALE, BigInteger.valueOf(124864));
        Employee employee2 = new Employee("Aeriell","McNee","amcnee1@google.es", LocalDate.of(2009,1,26), Gender.MALE, BigInteger.valueOf(114864));
        Employee employee3 = new Employee("Sydney","Symonds","ssymonds2@hhs.gov", LocalDate.of(2010,5,17), Gender.FEMALE, BigInteger.valueOf(204864));
        Employee employee4 = new Employee("Avrom","Rowantree",null, LocalDate.of(2014,8,2), Gender.MALE, BigInteger.valueOf(150864));

        employee1.setDepartment(department1);
        employee2.setDepartment(department2);
        employee3.setDepartment(department3);
        employee4.setDepartment(department4);

//        departmentsRepository.save(department1);
//        departmentsRepository.save(department2);
//        departmentsRepository.save(department3);

        employeesRepository.save(employee1);
        employeesRepository.save(employee2);
        employeesRepository.save(employee3);
        employeesRepository.save(employee4);
    }
}
