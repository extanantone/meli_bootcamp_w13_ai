package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;
    private String firstName;
    private String lastName;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favoriteMovieId")
    Movies movies;

    /*
    @ManyToMany(mappedBy = "actorsSet")
    Set<Movies> moviesSet;

     @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    Set<Episodes> episodesSet;
    */
}
