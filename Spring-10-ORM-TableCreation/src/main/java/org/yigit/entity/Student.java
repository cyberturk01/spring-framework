package org.yigit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    private Long id;
}
