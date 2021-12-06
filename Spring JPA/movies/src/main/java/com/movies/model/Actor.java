package com.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createAt;

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
