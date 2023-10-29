package org.yigit.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yigit.enums.Role;

@Entity
@Table(name = "accountDetails")
@Data
@NoArgsConstructor
public class AccountDetail extends BaseEntity{
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private String age;
    private String postalCode;
    private Role role;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;

    public AccountDetail(String name, String address, String country, String city, String state, String age, String postalCode, Role role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
