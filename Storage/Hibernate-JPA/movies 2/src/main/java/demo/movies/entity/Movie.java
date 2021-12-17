package demo.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;
    private double rating;
    private int awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> cast;

    @ManyToOne
    @JoinColumn (name = "genre_id")
    Genre genre;



}
