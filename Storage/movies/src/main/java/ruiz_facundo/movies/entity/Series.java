package ruiz_facundo.movies.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Series {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre seriesGenre;
}
