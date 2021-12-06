package com.example.moviesmysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Column(length = 500)
    private String title;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "favouriteMovie")
    private Set<Actor> actor;

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies;
}
