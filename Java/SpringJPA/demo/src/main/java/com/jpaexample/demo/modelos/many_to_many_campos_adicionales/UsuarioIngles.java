package com.jpaexample.demo.modelos.many_to_many_campos_adicionales;

import com.jpaexample.demo.modelos.movies.Actors;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UsuarioIngles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "usuarioIngles")
    private Set<RompeUsuarioInglesThanks> rompeUsuarioInglesThanks;


}
