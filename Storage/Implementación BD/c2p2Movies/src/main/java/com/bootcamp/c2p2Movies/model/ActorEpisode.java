package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actors actors;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episodes episodes;
}
