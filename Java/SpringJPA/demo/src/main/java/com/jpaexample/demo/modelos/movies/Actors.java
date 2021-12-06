package com.jpaexample.demo.modelos.movies;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movies favorite_movie;

    @OneToMany(mappedBy = "actor")
    private Set<ActorsMovies> actorsMovies;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate created_at;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate updated_at;

    private String first_name;
    private String last_name;
    private Float rating;

}
