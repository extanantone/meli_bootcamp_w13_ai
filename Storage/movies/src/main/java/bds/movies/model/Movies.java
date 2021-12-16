package bds.movies.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "movies")
@Getter
public class Movies {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "created_at")
    Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    Date updatedAt;
    @Column(length = 40)
    String title;
    @Column(precision = 3, scale = 1)
    Double rating;
    Integer awards;
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    Date releaseDate;
    Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genres genres;
    @OneToMany
    @JoinColumn(name = "favorite_movie_id")
    Set<Actors> actorsFavorite;
}
