package com.bootcamp.moviesdbder.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "seasons")
public class Season {

    @Id
    private int id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(length = 500)
    private String title;

    private int number;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @OneToMany
    @JoinColumn(name = "season_id")
    private List<Episode> episodes;
}
