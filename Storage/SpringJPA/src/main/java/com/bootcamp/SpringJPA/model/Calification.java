package com.bootcamp.SpringJPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter
@Entity
@Table(name = "Calificacion")
public class Calification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "parcial_1", precision = 4, scale = 2)
    private BigDecimal parcial1;

    @Column(name = "parcial_2", precision = 4, scale = 2)
    private BigDecimal parcial2;

    @Column(name = "trabajo_integrador", precision = 4, scale = 2)
    private BigDecimal trabajoIntegrador;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
