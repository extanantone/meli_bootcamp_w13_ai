package com.bootcamp.MapeoMoviesDB.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Date updatedAt;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(precision = 3, scale = 1, nullable = false)
    private BigDecimal rating;

    @Column(nullable = false)
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    private Integer length;

    //Relaciones
    @OneToMany(mappedBy = "favoriteMovie")
    private Set<Actor> actorsWithThisFavMovie;

    /*@ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;*/

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> setActorMovie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
