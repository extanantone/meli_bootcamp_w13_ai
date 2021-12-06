package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;
    private String title;
    private Double raiting;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer lenght;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genres;

    /* @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    Set<Actors> actorsSet; */
}
