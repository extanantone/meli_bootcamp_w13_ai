package bds.movies.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "series")

public class Series {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    Date updatedAt;
    @Column(length = 500)
    String title;
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    java.util.Date releaseDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    Date endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genres genres;

}
