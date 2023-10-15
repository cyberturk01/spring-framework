package org.yigit.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mentor {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String batch;
    private boolean graduated;
    private String company;
}
