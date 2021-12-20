package com.mercadolibre.relaciones.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Serie {
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
    @Size(max = 25)
    String title;

    @Column(name = "release_date", nullable = false)
    LocalDate releaseDate;

    @Column(name = "end_date", nullable = false)
    LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    Genre genre;
}
