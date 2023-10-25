package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.entity.Departments;
import org.yigit.entity.Employees;
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

        Departments departments1= new Departments("Clothing","Home");
        Departments departments2= new Departments("Grocery","Home");
        Departments departments3= new Departments("Decor","Home");

        Employees employees1= new Employees("Berrie","Manueau","bmanueau0@dion.ne.jp", LocalDate.of(2006,4,20), Gender.FEMALE, BigInteger.valueOf(124864));
        Employees employees2= new Employees("Aeriell","McNee","amcnee1@google.es", LocalDate.of(2009,1,26), Gender.MALE, BigInteger.valueOf(114864));
        Employees employees3= new Employees("Sydney","Symonds","ssymonds2@hhs.gov", LocalDate.of(2010,5,17), Gender.FEMALE, BigInteger.valueOf(204864));
        Employees employees4= new Employees("Avrom","Rowantree",null, LocalDate.of(2014,8,2), Gender.MALE, BigInteger.valueOf(150864));

        departmentsRepository.save(departments1);
        departmentsRepository.save(departments2);
        departmentsRepository.save(departments3);

        employeesRepository.save(employees1);
        employeesRepository.save(employees2);
        employeesRepository.save(employees3);
        employeesRepository.save(employees4);
    }
}
