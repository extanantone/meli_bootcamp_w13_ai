package com.meliboopcamp.implementacionDB.c2Practica.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDTO {

    private String title;
    private double rating;
    private int awards;
}
