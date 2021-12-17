package ruiz_facundo.movies.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MovieActor {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movieId;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actorId;

    private Date created_at;
    private Date updated_at;
}
