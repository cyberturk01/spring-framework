package org.yigit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yigit.enums.Gender;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity{


    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigInteger salary;

    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regionId")
    private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, BigInteger salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
