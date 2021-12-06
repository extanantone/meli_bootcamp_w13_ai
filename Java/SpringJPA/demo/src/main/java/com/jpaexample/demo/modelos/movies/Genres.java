package com.jpaexample.demo.modelos.movies;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "genero")
    private Set<Movies> movies;

    @Column(columnDefinition = "TIMESTAMP")
    private String created_at;
    @Column(columnDefinition = "TIMESTAMP")
    private String updated_at;

    private String name;
    private String ranking;
    private String active;

}
