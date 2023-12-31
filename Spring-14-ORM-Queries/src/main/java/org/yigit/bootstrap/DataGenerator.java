package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.entity.Region;
import org.yigit.repository.CourseRepository;
import org.yigit.repository.DepartmentRepository;
import org.yigit.repository.EmployeeRepository;
import org.yigit.repository.RegionRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------Region Start here---------");
        List<Region> canada =  regionRepository.findByCountry("Canada");

        System.out.println(canada);
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findByCountryContains("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println(regionRepository.findTop2ByCountry("Canada"));

        System.out.println("--------Region end here---------");

        System.out.println("--------Department Start here---------");
        System.out.println(departmentRepository.findByDepartment("Furniture"));
        System.out.println(departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println(departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));


        System.out.println("--------Department end here---------");

        System.out.println("--------Employee Start here---------");
        System.out.println(employeeRepository.findByEmail("amcnee1@google.es"));
        System.out.println(employeeRepository.findByFirstNameAndLastNameOrEmail("Berrie", "Manueau","bmanueau0@dion.ne.jp" ));
        System.out.println(employeeRepository.findByFirstNameIsNot("Berrie"));
        System.out.println(employeeRepository.findByLastNameIsStartingWith("Ber"));
        System.out.println(employeeRepository.findBySalaryIsGreaterThan(160000));
        System.out.println(employeeRepository.findBySalaryLessThan(120000));
        System.out.println(employeeRepository.findByHireDateBetween(LocalDate.of(2019,3,12),LocalDate.of(2023,3,12)));
        System.out.println(employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(140000));
        System.out.println(employeeRepository.findDistinctTop3BySalaryLessThan(140000));
        System.out.println(employeeRepository.findByEmailIsNull());

        //JPQL
        System.out.println("getEmployeeDetail: "+employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeSalary());
        System.out.println("--------Employee end here---------");

        System.out.println("--------Derive Query Samples start here---------");

        System.out.println("Category: " + courseRepository.findByCategory("Spring"));
//        System.out.println("Category: " + courseRepository.getCategory("Spring"));
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("Getting Started with Spring Cloud Kubernetes"));
        System.out.println(courseRepository.countByCategory("Spring"));
        System.out.println(courseRepository.findByNameStartingWith("Getting Started"));
//        System.out.println(courseRepository.streamByCategory("Spring"));
//
        System.out.println(employeeRepository.getEmployeeSalaryNotEqual(15000));
        System.out.println(employeeRepository.getEmployeeFirstNameLike("har"));
        System.out.println("--------Derive Query Samples end here---------");

    }
}
