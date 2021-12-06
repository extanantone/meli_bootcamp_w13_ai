package com.example.moviesmysql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "actor_movie")
public class ActorMovie {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne
    @MapsId("actor_id")
    private Actor actor;

    @ManyToOne
    @MapsId("movie_id")
    private Movie movie;
}
