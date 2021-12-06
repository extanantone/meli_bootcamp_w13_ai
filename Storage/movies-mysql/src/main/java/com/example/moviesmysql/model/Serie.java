package com.example.moviesmysql.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "series")
public class Serie {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @Column(length = 500)
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    private Set<Season> seasons;
}
