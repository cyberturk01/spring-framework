package org.yigit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity {
    private String address;
    private String email;
    private String name;
    private String surname;
    private String userName;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Payment> payment;

    public Customer(String address, String email, String name, String surname, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
    }
}
