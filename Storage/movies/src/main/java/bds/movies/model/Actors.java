package bds.movies.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "actors")
public class Actors {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    Date updatedAt;
    @Column(name = "first_name" , length = 100)
    String firstName;
    @Column(name = "last_name",length = 100)
    String lastName;
    @Column(precision = 3, scale = 1)
    Double rating;

}
