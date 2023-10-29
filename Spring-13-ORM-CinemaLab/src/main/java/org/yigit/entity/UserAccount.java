package org.yigit.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userAccounts")
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountDetail accountDetails;

}
