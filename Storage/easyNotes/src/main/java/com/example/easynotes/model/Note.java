package com.example.easynotes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    //fetch = FetchType.LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
}
