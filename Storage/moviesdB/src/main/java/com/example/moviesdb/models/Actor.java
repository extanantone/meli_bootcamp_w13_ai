package com.example.moviesdb.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Actor {

    @Id
    @GeneratedValue
    Long id;


    @JoinColumn(name="favorite_movie_id")
    @ManyToOne
    Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors")
    Set<Movie> movies;

}
