package demo.movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Getter
@Setter
public class Seasons {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int number;

    private LocalDate release_date;
    private LocalDate end_date;

    @ManyToOne
    Serie serie;

    @OneToMany(mappedBy = "season")
    private Set<Episodes> episodes;

}
