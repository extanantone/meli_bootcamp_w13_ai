package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private Set<Series> series;

}
