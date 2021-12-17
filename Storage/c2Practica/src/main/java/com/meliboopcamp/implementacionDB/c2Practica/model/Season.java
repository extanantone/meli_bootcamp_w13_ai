package com.meliboopcamp.implementacionDB.c2Practica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int number;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series season_series;
}
