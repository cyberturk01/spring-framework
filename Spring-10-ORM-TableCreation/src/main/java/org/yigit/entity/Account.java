package org.yigit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@MappedSuperclass
public class Account {

    //Working with parent child with @MappedSuperClass
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
