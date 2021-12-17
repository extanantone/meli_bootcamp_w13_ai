package com.meliboopcamp.implementacionDB.c2Practica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    private Long id;

    private String title;
    private int number;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(nullable = false)
    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season episode_season;

    @ManyToMany
    @JoinTable(
            name = "episode_cast",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> cast;

    private Date created_at;

}
