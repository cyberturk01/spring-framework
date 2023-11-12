package org.yigit.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userAccount")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountDetailsId")
    private Account account;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
