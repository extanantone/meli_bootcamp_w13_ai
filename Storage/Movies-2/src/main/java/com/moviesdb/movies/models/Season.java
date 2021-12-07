package com.moviesdb.movies.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    private String title;
    private int number;

    private LocalDate releaseDate;
    private LocalDate endDate;

    /*@ManyToOne
    private Series series;*/


}
