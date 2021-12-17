package demo.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Getter
@Setter
public class Episodes {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int number;

    private LocalDate release_date;

    @ManyToOne
    @JoinColumn(name = "season_id")
    Seasons season;

    @ManyToMany
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> cast;

}
