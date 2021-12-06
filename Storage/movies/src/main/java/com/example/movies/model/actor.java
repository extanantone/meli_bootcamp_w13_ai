package com.example.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class actor {
    @Id
    @GeneratedValue
    Long actor_id;

    @ManyToMany
    @JoinTable(name ="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie"))
    Set<movie>movies = new HashSet<>();
}
