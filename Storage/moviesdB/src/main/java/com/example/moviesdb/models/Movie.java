package com.example.moviesdb.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    Long id;


    @OneToMany(mappedBy = "favoriteMovie")
    Set<Actor> FavoriteActorMovie;

    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    Set<Actor> actors;


}
