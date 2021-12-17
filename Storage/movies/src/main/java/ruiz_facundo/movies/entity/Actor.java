package ruiz_facundo.movies.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {
    @Id
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

    @OneToMany(mappedBy = "actorId")
    private Set<MovieActor> filmography;

    @ManyToMany(mappedBy = "cast")
    private Set<Episode> repetuoire;
}
