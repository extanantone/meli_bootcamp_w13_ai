package com.jpaexample.demo.modelos.many_to_many_campos_adicionales;

import com.jpaexample.demo.modelos.primaries_keys.UsuarioInglesThanksKey;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
 **/
@Data
@Entity
public class RompeUsuarioInglesThanks {

    @EmbeddedId
    private UsuarioInglesThanksKey id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate fechaCreacion;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate fechaActualizacion;

    @ManyToOne
    @MapsId("thanksId")
    @JoinColumn(name = "thanks_id")
    private Thanks thanks;

    @ManyToOne
    @MapsId("usuarioInglesId")
    @JoinColumn(name = "usuario_ingles_id")
    private UsuarioIngles usuarioIngles;

}
