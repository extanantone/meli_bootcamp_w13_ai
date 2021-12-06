package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Timestamp updatedAt;

    @Column(length = 500)
    private String title;

    @Column(precision = 3, scale = 1)
    private Double rating;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer length;

    @ManyToMany
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn
    private Genre genre;
}
