package ruiz_facundo.movies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int ranking;
    private boolean active;

    @OneToMany(mappedBy = "genre")
    Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    Set<Serie> series;
}
