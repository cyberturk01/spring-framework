package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genreList")
    @JsonIgnore
    private List<Movie> movieList;

}
