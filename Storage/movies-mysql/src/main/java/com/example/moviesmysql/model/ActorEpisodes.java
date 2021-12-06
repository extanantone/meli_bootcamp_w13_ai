package com.example.moviesmysql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "actor_episodes")
public class ActorEpisodes {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne
    @MapsId("actor_id")
    private Actor actor;

    @ManyToOne
    @MapsId("episode_id")
    private Episode episode;
}
