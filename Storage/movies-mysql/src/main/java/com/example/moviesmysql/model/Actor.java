package com.example.moviesmysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity(name = "actors")
public class Actor {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "movies_id")
    private Movie favouriteMovie;

    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private Set<ActorEpisodes> actorEpisodes;
}
