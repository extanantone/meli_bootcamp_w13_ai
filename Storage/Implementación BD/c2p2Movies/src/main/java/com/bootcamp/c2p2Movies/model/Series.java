package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genres;
}
