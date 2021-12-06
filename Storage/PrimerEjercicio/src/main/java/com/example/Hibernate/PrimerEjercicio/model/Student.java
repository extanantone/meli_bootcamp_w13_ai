package com.example.Hibernate.PrimerEjercicio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DNI")
    private String dni;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastname;
    private Double parcial1;
    private Double parcial2;
    private Double trabajoIntegrador;

    @OneToOne
            @JoinColumn(name="address_id")
    Address address;
}
