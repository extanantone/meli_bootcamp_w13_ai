package com.bootcamp.c2p2Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Seasons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updateddAt;
    private String title;
    private Integer number;
    private LocalDate releasedDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Series series;
}
