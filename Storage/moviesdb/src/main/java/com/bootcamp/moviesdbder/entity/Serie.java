package com.bootcamp.moviesdbder.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "series")
public class Serie {

    @Id
    private int id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @OneToMany()
    @JoinColumn(name = "serie_id")
    private List<Season> seasons;
}
