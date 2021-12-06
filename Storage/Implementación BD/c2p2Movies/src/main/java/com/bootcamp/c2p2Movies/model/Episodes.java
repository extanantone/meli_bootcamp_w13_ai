package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Episodes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;
    private String title;
    private Integer number;
    private LocalDate releasedDate;
    private LocalDate endDate;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Seasons seasons;

    /*
    @ManyToMany(mappedBy = "episodesSet")
    Set<Actors> actorsSet;
    */

}
