package com.jpaexample.demo.modelos.many_to_many_campos_adicionales;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Thanks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "thanks")
    private Set<RompeUsuarioInglesThanks> rompeUsuarioInglesThanks;

}
