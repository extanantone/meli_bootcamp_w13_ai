package bds.movies.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "episodes")
public class Episodes {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    java.util.Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    Date updatedAt;
    @Column(length = 500)
    String title;
    Integer number;
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    java.util.Date releaseDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    Date endDate;
    @Column(precision = 3, scale = 1)
    Double rating;
    @ManyToOne
    @JoinColumn(name = "season_id")
    Seasons season;
}
