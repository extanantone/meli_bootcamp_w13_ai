package demo.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "actors")
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    @JsonBackReference
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "cast")
    @JsonManagedReference
    private Set<Movie> filmography;


}
