package com.bootcamp.tutorials.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tittle", length = 500, nullable = false)
    private String title;

    @Column(name = "description", length = 2000, nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean published;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Date createDateTime;

    @UpdateTimestamp
    @Column(name = "update_at", columnDefinition = "TIMESTAMP")
    private Date updateDateTime;

    public Tutorial() {
        this.published = true;
    }

    public Tutorial(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
}
