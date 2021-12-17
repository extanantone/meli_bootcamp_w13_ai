package ruiz_facundo.movies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int ranking;
    @Column(nullable = false)
    private boolean active;
}
