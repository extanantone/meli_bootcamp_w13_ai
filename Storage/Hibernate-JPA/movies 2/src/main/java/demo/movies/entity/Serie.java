package ruiz_facundo.movies.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
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




}
