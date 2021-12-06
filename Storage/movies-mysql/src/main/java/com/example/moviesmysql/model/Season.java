package com.example.moviesmysql.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "seasons")
public class Season {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @Column(length = 500)
    private String title;

    private Integer number;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes;
}
