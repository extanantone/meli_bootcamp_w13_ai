package bds.movies.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seasons")
public class Seasons {
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
    @ManyToOne
    @JoinColumn(name = "serie_id")
    Series series;
}
