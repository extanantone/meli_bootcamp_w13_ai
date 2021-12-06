package com.jpaexample.demo.modelos.movies;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "id_genero")
    private Genres genero;

    @OneToMany(mappedBy = "favorite_movie")
    private Set<Actors> actors_prefered;

    @OneToMany(mappedBy = "movie")
    private Set<ActorsMovies> moviesActors;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate createdAt;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate updatedAt;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate release_date;

    private String title;
    private Integer rating;
    private Integer awards;
    private Integer length;

}
