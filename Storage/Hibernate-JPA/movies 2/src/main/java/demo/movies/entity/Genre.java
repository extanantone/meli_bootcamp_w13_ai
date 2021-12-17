package demo.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    private int ranking;
    private boolean active;

    @OneToMany(mappedBy = "genre")
    Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    Set<Serie> series;
}
