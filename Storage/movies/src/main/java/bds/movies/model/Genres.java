package bds.movies.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
public class Genres {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    java.util.Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    Date updatedAt;
    @Column(length = 100)
    String name;
    Integer ranking;
    @Column(length = 1)
    Short active;
    // Prueba de bidireccional
    @OneToMany(mappedBy = "genres")
    Set<Series> series;

}
