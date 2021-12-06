package com.example.moviesmysql.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate releaseDate;

    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisodes> actorEpisodes;
}
