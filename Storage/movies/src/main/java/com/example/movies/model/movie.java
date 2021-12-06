package com.example.movies.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
public class movie {
    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(mappedBy = "movies")
    Set<actor> actores = new HashSet<>();
}
