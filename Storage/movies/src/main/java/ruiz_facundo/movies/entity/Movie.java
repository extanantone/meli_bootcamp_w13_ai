package ruiz_facundo.movies.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Movie {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    private double rating;
    private int awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    /*@ManyToMany
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )*/
    @OneToMany(mappedBy = "movieId")
    private Set<MovieActor> cast;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre movieGenre;
}
