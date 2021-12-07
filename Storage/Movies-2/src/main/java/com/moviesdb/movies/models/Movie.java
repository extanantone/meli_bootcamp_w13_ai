package com.moviesdb.movies.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private double rating;
    private int awards;
    private LocalDate releaseDate;
    private int length;

    //Porque si hay tabla intermedia tambien existe este ralacion?
    /*@OneToMany(mappedBy = "actors")
    Set<Actor> actors = new HashSet<>();*/

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private Set<Actor> actors;


}
