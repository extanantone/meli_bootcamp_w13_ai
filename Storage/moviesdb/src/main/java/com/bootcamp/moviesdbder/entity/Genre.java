package com.bootcamp.moviesdbder.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity(name = "genres")
public class Genre {

    @Id
    @Column(unique = true)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer ranking;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Movie> movies;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Serie> series;
}
