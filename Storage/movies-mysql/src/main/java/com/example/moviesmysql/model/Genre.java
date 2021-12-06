package com.example.moviesmysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Column(length = 100)
    private String name;

    private Integer ranking;
    private Byte active;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private Set<Serie> series;
}
