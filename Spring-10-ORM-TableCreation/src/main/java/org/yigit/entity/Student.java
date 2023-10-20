package org.yigit.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.yigit.enums.Gender;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;

    @Column(name = "studentLastName")
    private String lastName;

    @Column(name = "studentEmail")
    private String email;

    //Dont add it to Table
    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;

    @Column(columnDefinition = "TIME")
    private LocalTime birthtime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTimeStamp;

    //Use for Enums
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
