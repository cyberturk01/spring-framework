package org.yigit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Employee {
    private String name;
    private String department;
    private Integer hourlyRate;
}
