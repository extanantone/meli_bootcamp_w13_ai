package com.meliboopcamp.implementacionDB.c2Practica.dtos;

import com.meliboopcamp.implementacionDB.c2Practica.model.Movie;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private String firstName;
    private String lastName;
    private double rating;
    private MoviesDTO favoriteMovie;
}
