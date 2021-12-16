package bds.movies.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    java.util.Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "updated_at")
    Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    Actors actor;
    @ManyToOne
    @JoinColumn(name = "episode_id")
    Episodes episode;
}
