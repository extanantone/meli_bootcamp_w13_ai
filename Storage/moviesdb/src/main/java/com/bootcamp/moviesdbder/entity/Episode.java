package com.bootcamp.moviesdbder.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "episodes")
public class Episode {

    @Id
    private int id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(length = 500)
    private String title;

    private int number;

    @Column(nullable = false, name = "release_date")
    private LocalDateTime releaseDate;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;
}
