package com.bootcamp.MapeoMoviesDB.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Genres")
public class Genre {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer ranking;

    @Column(nullable = false)
    private Boolean active;

    //Relaciones
    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private Set<Serie> series;

}
