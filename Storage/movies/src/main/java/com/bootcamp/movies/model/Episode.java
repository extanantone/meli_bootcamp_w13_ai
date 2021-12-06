package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 1)
    private Double rating;

    @ManyToOne
    @JoinColumn
    private Season season;

    @ManyToMany
    @JoinTable
    private Set<Actor> actors;
}
