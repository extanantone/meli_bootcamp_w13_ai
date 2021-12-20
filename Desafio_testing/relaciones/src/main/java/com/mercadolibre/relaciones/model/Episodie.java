package com.mercadolibre.relaciones.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Episodie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @NonNull
    @Size(max = 500)
    String title;

    @NonNull
    double rating;

    @NonNull
    @Size(max = 5)
    int number;

    @Column(name = "release_date", nullable = false)
    LocalDate releaseDate;

    @NonNull
    @Size(max = 10)
    int length;

    @ManyToOne(fetch = FetchType.LAZY)
    Season season;

    @ManyToMany(mappedBy = "episodieList")
    Set<Actor> actorList;
}
