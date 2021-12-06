package com.bootcamp.moviesdbder.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "episodes")
public class Episode {

    @Id
    private int id;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateDateTime;

    @Column(length = 500)
    private String title;

    private int number;

    @Column(nullable = false, name = "release_date")
    private LocalDateTime releaseDate;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;
}
