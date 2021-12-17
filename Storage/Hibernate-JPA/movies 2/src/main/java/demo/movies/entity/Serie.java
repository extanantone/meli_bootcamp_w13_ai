package demo.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "series")
@Getter
@Setter
public class Serie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Date release_date;
    private Date end_date;

    /*@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Timestamp updatedAt;*/

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;

    @OneToMany
    @JoinColumn(name = "serie_id")
    private Set<Seasons> seasons;




}
