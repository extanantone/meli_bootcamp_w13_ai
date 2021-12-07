package com.bootcamp.MapeoMoviesDB.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Episodes")
public class Episode {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 1, nullable = false)
    private BigDecimal rating;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisode> setActorEpisodes;
}
