package com.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "actors")
@Getter
@Setter
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "upload_at")
    private LocalDate uploadAt;

    @Column(name = "first_name")
    private String firsttName;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnoreProperties({"actors"})
    private Movie favoriteMovie;

}
