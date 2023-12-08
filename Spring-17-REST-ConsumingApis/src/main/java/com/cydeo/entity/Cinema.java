package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
