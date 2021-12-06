package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Timestamp updatedAt;

    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "ending_date")
    private LocalDate endingDate;

    @ManyToOne
    @JoinColumn
    private Series series;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes;
}
