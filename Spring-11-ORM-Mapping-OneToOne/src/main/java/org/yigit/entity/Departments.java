package org.yigit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "departments")
@Data
@NoArgsConstructor
public class Departments extends BaseEntity{

    private String department;
    private String division;

    public Departments(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
