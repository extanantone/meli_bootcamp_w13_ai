package com.bootcamp.moviesdbder.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity(name = "movies")
public class Movie {

    @Id
    @Column(unique = true)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateDateTime;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(nullable = false)
    private Integer awards;

    @Column(nullable = false, name = "release_date")
    private LocalDateTime releaseDate;

    private Integer length;

    @OneToMany
    @JoinColumn(name = "favorite_movie")
    private List<Actor> actorsFavorite;


}
