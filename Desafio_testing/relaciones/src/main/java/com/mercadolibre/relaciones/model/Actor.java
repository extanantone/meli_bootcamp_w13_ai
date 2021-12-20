package com.mercadolibre.relaciones.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(max = 100)
    String lastName;

    @NonNull
    double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    Movie favoriteMovieId;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    Set<Movie> movieList;

    @ManyToMany
    @JoinTable(
            name = "actor_episodie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episodie_id")
    )
    Set<Episodie> episodieList;
}
