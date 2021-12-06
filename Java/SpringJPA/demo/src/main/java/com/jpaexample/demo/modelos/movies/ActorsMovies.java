package com.jpaexample.demo.modelos.movies;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "actor_movie")
public class ActorsMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actors actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate created_at;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate updated_at;

}
